package com.lee.vrg.common.bo;

/**
 * 灵魂，user, 和特殊的goods,特殊的location 才能有，<br>
 * 用soul 才有生灵的属性，
 * 
 * @author dell
 *
 */
public class Soul {

	private Long id;

	/**
	 * 生命力
	 */
	private long health;

	/**
	 * 体力，每个人都是60, 赢得比赛回复全部，输了1s回一点
	 */
	private long power;

	/**
	 * 攻击力
	 */
	private long attack;

	/**
	 * 防御力
	 */
	private long denfanse;

	/**
	 * 幸运力
	 */
	private long luck;

	/**
	 * 两个攻击技能 {id:,chance}
	 * 
	 * 
	 */
	private String attackSkill;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public long getHealth() {
		return health;
	}

	public void setHealth(long health) {
		this.health = health;
	}

	public long getPower() {
		return power;
	}

	public void setPower(long power) {
		this.power = power;
	}

	public long getAttack() {
		return attack;
	}

	public void setAttack(long attack) {
		this.attack = attack;
	}

	public long getDenfanse() {
		return denfanse;
	}

	public void setDenfanse(long denfanse) {
		this.denfanse = denfanse;
	}

	public long getLuck() {
		return luck;
	}

	public void setLuck(long luck) {
		this.luck = luck;
	}

	public String getAttackSkill() {
		return attackSkill;
	}

	public void setAttackSkill(String attackSkill) {
		this.attackSkill = attackSkill;
	}

}
