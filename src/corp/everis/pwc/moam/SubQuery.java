package corp.everis.pwc.moam;

import corp.everis.pwc.raw.POWERMART;

public class SubQuery {
	protected String query;
	protected String alias;
	protected String tablename;
	protected String detailname;
	protected String detailalias;
	protected POWERMART powermart;
		
	public SubQuery() {
		super();
	}
	public SubQuery(String query, String alias) {
		super();
		this.query = query;
		this.alias = alias;
	}
	public SubQuery(String query, String alias, POWERMART powermart) {
		super();
		this.query = query;
		this.alias = alias;
		this.powermart = powermart;
	}
	public SubQuery(String query, String alias, String tablename, String detailname, String detailalias, POWERMART powermart) {
		super();
		this.query = query;
		this.alias = alias;
		this.tablename = tablename;
		this.detailname = detailname;
		this.detailalias = detailalias;
		this.powermart = powermart;
	}
	public SubQuery(SubQuery subquery) {
		super();
		this.query = subquery.query;
		this.alias = subquery.alias;
		this.tablename = subquery.tablename;
		this.detailname = subquery.detailname;
		this.detailalias = subquery.detailalias;
		this.powermart = subquery.powermart;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alias == null) ? 0 : alias.hashCode());
		result = prime * result + ((query == null) ? 0 : query.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SubQuery other = (SubQuery) obj;
		if (alias == null) {
			if (other.alias != null)
				return false;
		} else if (!alias.equals(other.alias))
			return false;
		if (query == null) {
			if (other.query != null)
				return false;
		} else if (!query.equals(other.query))
			return false;
		return true;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}
	public POWERMART getPowermart() {
		return powermart;
	}
	public void setPowermart(POWERMART powermart) {
		this.powermart = powermart;
	}
	public String getTablename() {
		return tablename;
	}
	public void setTablename(String tablename) {
		this.tablename = tablename;
	}
	public String getDetailname() {
		return detailname;
	}
	public void setDetailname(String detailname) {
		this.detailname = detailname;
	}
	public String getDetailalias() {
		return detailalias;
	}
	public void setDetailalias(String detailalias) {
		this.detailalias = detailalias;
	}
	
}
