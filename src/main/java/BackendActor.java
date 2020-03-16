import akka.actor.Props;

public class BackendActor extends BaseActor {

	Base<BaseMessage.SessionMesssage> session = new Decorator<>(new SessionFactory());
	Base<BaseMessage.AccessMesssage> access = new Decorator<>(new AccessFactory());

	public static Props props() {
		return Props.create(BackendActor.class);
	}

	@Override
	public Receive createReceive() {
		return receiveBuilder(). //
				match(BaseMessage.SessionMesssage.class, session::handleMethod). //
				match(BaseMessage.AccessMesssage.class, access::handleMethod). //
				build();
	}

	@Override
	public <T> void methodBefore(T obj) {
		System.out.println("Before job executed : " + obj.getClass().getSimpleName());
	}

	@Override
	public void methodAfter(Object result) {
		if (result instanceof SessionFactory.Return) {
			SessionFactory.Return sessionFactory = (SessionFactory.Return) result;
			System.out.println("SessionFactory return: " + sessionFactory.address);
		} else if (result instanceof AccessFactory.Return) {
			AccessFactory.Return accessFactory = (AccessFactory.Return) result;
			System.out.println("AccessFactory return: " + accessFactory.model);
		}
	}
}
