package com.lee.vrg.fate.bo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * 灵魂，user, 和特殊的goods,特殊的location 才能有，<br>
 * 用soul 才有生灵的属性，
 * 
 * @author dell
 *
 */
public class SoulBo {

	private Long id;

	/**
	 * 生命力
	 */
	private long health;

	/**
	 * 技能值
	 */
	private long magic;

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
	 * 攻击技能
	 */
	private List<SkillBo> attackSkill;

	/**
	 * 防御技能
	 */
	private List<SkillBo> defenceSkill;

	private List<ActionBo> pendingActionList = new ArrayList<ActionBo>();

	public SoulBo(Long id, long health, long magic, long power, long attack, long denfanse, long luck,
			List<SkillBo> attackSkill, List<SkillBo> defenceSkill) {
		this.id = id;
		this.health = health;
		this.magic = magic;
		this.power = power;
		this.attack = attack;
		this.denfanse = denfanse;
		this.luck = luck;
		this.attackSkill = attackSkill;
		this.defenceSkill = defenceSkill;
	}

	public void addPendingActionList(ActionBo pendingAction) {
		this.pendingActionList.add(pendingAction);
	}

	public ActionBo getOutPendingActionList(int target) {
		if (pendingActionList.size() == 0) {

			int attackSkillSize = attackSkill.size();
			int defenceSkillSize = defenceSkill.size();

			int randomNum = God.randomInt(3);

			// 攻击
			if (randomNum < 2) {
				return new ActionBo(this, null, target);
			}
			// 攻击技能
			if (randomNum == 2) {
				SkillBo skillBo = attackSkill.get(God.randomInt(attackSkillSize));
				this.magic = this.magic - skillBo.getMagicUse();
				return new ActionBo(this, skillBo, target);
			}
			// 防御技能
			if (randomNum == 3) {
				SkillBo skillBo = defenceSkill.get(God.randomInt(defenceSkillSize));
				this.magic = this.magic - skillBo.getMagicUse();
				return new ActionBo(this, skillBo, -1);
			}
			return null;
		} else {
			return pendingActionList.remove(0);
		}

	}

	public List<ActionBo> getPendingActionList() {
		return pendingActionList;
	}

	public long getMagic() {
		return magic;
	}

	public void setMagic(long magic) {
		this.magic = magic;
	}

	public void setPendingActionList(List<ActionBo> pendingActionList) {
		this.pendingActionList = pendingActionList;
	}

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

	public List<SkillBo> getAttackSkill() {
		return attackSkill;
	}

	public void setAttackSkill(List<SkillBo> attackSkill) {
		this.attackSkill = attackSkill;
	}

	public List<SkillBo> getDefenceSkill() {
		return defenceSkill;
	}

	public void setDefenceSkill(List<SkillBo> defenceSkill) {
		this.defenceSkill = defenceSkill;
	}

	/**
	 * 受伤
	 * 
	 * @param attack
	 */
	public void hurt(long attack) {
		// 防御生效
		if (God.randomInt(100) < this.luck) {
			if ((attack - denfanse) > 0) {
				this.health = this.health - attack - denfanse;
			}
			System.err.println("");
			System.err.println("防御生效");
			System.err.println("生命减少 : " + ((attack - denfanse) > 0 ? (attack - denfanse) : 0));

		} else {
			this.health = this.health - attack;
			System.err.println("");
			System.err.println("生命减少 : " + attack);
		}

	}

	/**
	 * 受到技能
	 * 
	 * @param skillBo
	 * @throws Exception
	 */
	public void skill(SkillBo skillBo) {
		try {

			long change = 0;

			if (skillBo.getEffectObject().equals("self")) {
				change = this.luck + skillBo.getEffectChance();
			} else {
				change = +skillBo.getEffectChance() - this.luck;
			}

			if (God.randomInt(100) < change) {
				System.err.println("技能:" + skillBo.getName() + "生效");
				Field f = this.getClass().getDeclaredField(skillBo.getEffectProperty());
				f.setAccessible(true);
				long p = (long) f.get(this);
				p = p + skillBo.getEffectNum();
				f.set(this, p);
				System.err.println(
						"主体:" + this.getId() + "," + skillBo.getEffectProperty() + "," + skillBo.getEffectNum());
			} else {

			}
		} catch (Exception e) {
		}

	}

}
