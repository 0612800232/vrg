package com.lee.vrg.common.bo;

/**
 * 技能
 * @author dell
 *
 */
public class SkillBo {
	private Long id;

	private String name;
	
	/**
	 * 影响目标的某一属性
	 */
	private String effectProperty;
	
	/**
	 * 消耗的体力值
	 */
	private long powerUse;
	
	/**
	 * 技能数值
	 */
	private long effectNum;
	
	/**
	 * 技能触发概率
	 */
	private long effectChance;
	
	/**
	 * 受技能影响的目标， self|other|team|all
	 */
	private String effectObject;
	
	/**
	 * 技能持续时间
	 */
	private long effectTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

	public long getPowerUse() {
		return powerUse;
	}

	public void setPowerUse(long powerUse) {
		this.powerUse = powerUse;
	}

	public String getEffectProperty() {
		return effectProperty;
	}

	public void setEffectProperty(String effectProperty) {
		this.effectProperty = effectProperty;
	}

	
	
	public long getEffectNum() {
		return effectNum;
	}

	public void setEffectNum(long effectNum) {
		this.effectNum = effectNum;
	}

	public long getEffectChance() {
		return effectChance;
	}

	public void setEffectChance(long effectChance) {
		this.effectChance = effectChance;
	}

	public String getEffectObject() {
		return effectObject;
	}

	public void setEffectObject(String effectObject) {
		this.effectObject = effectObject;
	}

	public long getEffectTime() {
		return effectTime;
	}

	public void setEffectTime(long effectTime) {
		this.effectTime = effectTime;
	}

}
