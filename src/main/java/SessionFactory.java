public class SessionFactory implements BaseActor.Base<BaseMessage.SessionMesssage> {

	@Override
	public SessionFactory.Return handleMethod(BaseMessage.SessionMesssage obj) {
		SessionFactory.Return ret = new SessionFactory.Return();
		ret.message = obj.field;
		System.out.println("SessionFactory handleMethod: " + ret.message);
		return ret;
	}

	public class Return {
		public String message;
	}
}