import akka.actor.AbstractActor;

public abstract class BaseActor extends AbstractActor {

	public interface Base<T> {
		Object handleMethod(T obj);
	}

	public class Decorator<T> implements Base<T> {
		Base<T> baseDecorator;

		public Decorator(Base<T> b) {
			this.baseDecorator = b;
		}

		@Override
		public Object handleMethod(T obj) {

			methodBefore(obj);
			
			Object result = baseDecorator.handleMethod(obj);
			
			methodAfter(result);

			return result;
		}
	}

	abstract <T> void methodBefore(T obj);

	abstract void methodAfter(Object result);
}
