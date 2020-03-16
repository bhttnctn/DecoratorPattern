import akka.actor.ActorRef;
import akka.actor.ActorSystem;

public class DecoratorActorSystem {
	public static void main(String[] args) {
		ActorSystem system = ActorSystem.create("decorator-pattern");

		ActorRef supervisor = system.actorOf(BackendActor.props(), "supervisor");
		supervisor.tell(new BaseMessage.SessionMesssage(), ActorRef.noSender());
		supervisor.tell(new BaseMessage.AccessMesssage(), ActorRef.noSender());
	}
}
