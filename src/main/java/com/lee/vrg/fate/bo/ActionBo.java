package com.lee.vrg.fate.bo;

/**
 * 行动
 * 
 * @author dell
 *
 */
public class ActionBo {
	private SoulBo soulBo;
	private SkillBo skillBo;
	private int target;

	public ActionBo(SoulBo soulBo, SkillBo skillBo, int target) {
		this.soulBo = soulBo;
		this.skillBo = skillBo;
		this.target = target;
	}

	@Override
	public String toString() {
		return "主体:" + soulBo.getId() + ", 对目标:" + target + "实施:"
				+ (skillBo == null ? "攻击,攻击力"
						+ soulBo.getAttack()
						: "技能" + skillBo.getName() + ",技能说明:" + skillBo.getEffectProperty() + "|"
								+ skillBo.getEffectNum());
	}

	public SoulBo getSoulBo() {
		return soulBo;
	}

	public void setSoulBo(SoulBo soulBo) {
		this.soulBo = soulBo;
	}

	public SkillBo getSkillBo() {
		return skillBo;
	}

	public void setSkillBo(SkillBo skillBo) {
		this.skillBo = skillBo;
	}

	public int getTarget() {
		return target;
	}

	public void setTarget(int target) {
		this.target = target;
	}

}
