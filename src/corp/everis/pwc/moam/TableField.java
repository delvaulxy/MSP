package corp.everis.pwc.moam;

import java.util.Objects;

import corp.everis.pwc.raw.SOURCE;

public class TableField {
	protected String name;
	protected String alias;
	protected String datatype;
	protected String length;
	protected String precision;
	
	public TableField(String name, String alias) {
		super();
		this.name = name;
		this.alias = alias;
	}
	
	public TableField() {
		// TODO Auto-generated constructor stub
	}

	public TableField(TableField tblfld1) {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getDatatype() {
		return datatype;
	}
	public void setDatatype(String datatype) {
		this.datatype = datatype;
	}
	public String getLength() {
		return length;
	}
	public void setLength(String length) {
		this.length = length;
	}
	public String getPrecision() {
		return precision;
	}
	public void setPrecision(String precision) {
		this.precision = precision;
	}
	@Override
	public boolean equals(Object v) {
		boolean retVal = false;

		if (v instanceof TableField){
			TableField ptr = (TableField) v;
			retVal = true;
			if(null!=ptr.getName() && !ptr.getName().equals(this.name)){
				retVal = false;
			}
			if(null!=ptr.getAlias() && !ptr.getAlias().equals(this.alias)){
				retVal = false;
			}
			if(null!=ptr.getDatatype() && !ptr.getDatatype().equals(this.datatype)){
				retVal = false;
			}
			if(null!=ptr.getLength() && !ptr.getLength().equals(this.length)){
				retVal = false;
			}
			if(null!=ptr.getPrecision() && !ptr.getPrecision().equals(this.precision)){
				retVal = false;
			}
			
		}
		
		return retVal;
	}
	@Override
	public int hashCode() {
		return Objects.hash(name,alias,datatype,length,precision);
	}
	
}
