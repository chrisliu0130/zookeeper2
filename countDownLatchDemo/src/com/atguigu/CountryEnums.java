package com.atguigu;

public enum CountryEnums {
	ONE(1, "Æë"), TWO(2, "³þ"), THREE(3, "Ñà"), FOUR(4, "º«"), FIVE(5, "ÕÔ"), SIX(6, "Îº");

	private Integer retCode;
	private String retMsg;

	private CountryEnums(Integer retCode, String retMsg) {
		this.retCode = retCode;
		this.retMsg = retMsg;
	}

	public Integer getRetCode() {
		return retCode;
	}

	public void setRetCode(Integer retCode) {
		this.retCode = retCode;
	}

	public String getRetMsg() {
		return retMsg;
	}

	public void setRetMsg(String retMsg) {
		this.retMsg = retMsg;
	};

	public static CountryEnums forEachCountry(Integer index) {

		for (CountryEnums country : values()) {
			if(country.getRetCode()==index) {
				return country;
			}
		}
		return null;
		
	}

}
