package com.atguigu;

public enum Season {
	ONE(1, "spring"), TWO(2, "summer"), THREE(3, "autumn"), FOUR(4, "winter");

	private Integer id;
	private String name;

	private Season(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static Season foreEachSeason(Integer index) {
		for (Season season : values()) {
			if (season.getId() == index) {
				return season;
			}
		}
		
		/*
		 * for (int i = 1; i <=Season.values().length; i++) { if(i==index) { return
		 * Season.values()[i-1]; } }
		 */
		return null;
	}

}
