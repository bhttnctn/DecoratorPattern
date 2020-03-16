public class BaseMessage {

	protected String config;
	protected String dao;

	public String getConfig() {
		return config;
	}

	public void setConfig(String config) {
		this.config = config;
	}

	public String getDao() {
		return dao;
	}

	public void setDao(String dao) {
		this.dao = dao;
	}

	public static class SessionMesssage {
		public String field = "Session established !";
	}

	public static class AccessMesssage {
		public String field = "Access established !";
	}
}
