public class AccessFactory implements BaseActor.Base<BaseMessage.AccessMesssage> {

	@Override
	public AccessFactory.Return handleMethod(BaseMessage.AccessMesssage obj) {
		AccessFactory.Return ret = new AccessFactory.Return();
		ret.message = obj.field;
		System.out.println("AccessFactory handleMethod: " + ret.message);
		return ret;
	}

	public class Return {
		public String message;
	}
}