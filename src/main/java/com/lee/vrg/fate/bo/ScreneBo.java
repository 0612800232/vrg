package com.lee.vrg.fate.bo;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.lee.vrg.common.bo.LocationBo;

/**
 * 场景
 * 
 * @author dell
 *
 */
public class ScreneBo {

	private List<SoulBo> attackTeam;
	private List<SoulBo> denfenceTeam;

	/**
	 * 地理信息
	 */
	private LocationBo locationBo;

	/**
	 * 天气
	 */
	private String weather;

	/**
	 * 生命力比例 100%
	 */
	private long health;

	/**
	 * 体力比例
	 */
	private long magic;

	/**
	 * 攻击力比例
	 */
	private long attack;

	/**
	 * 防御力比例
	 */
	private long denfanse;

	/**
	 * 幸运力比例
	 */
	private long luck;

	private List<ActionBo> actionBoLog = new ArrayList<ActionBo>();

	public ScreneBo(List<SoulBo> attackTeam, SoulBo defenceTeam, LocationBo locationBo) {

		// 初始化环境
		this.health = God.randomInt(10);
		this.magic = God.randomInt(10);
		this.attack = God.randomInt(10);
		this.denfanse = God.randomInt(10);
		this.luck = God.randomInt(10);
		this.attackTeam = attackTeam;
		this.denfenceTeam = new ArrayList<SoulBo>();
		this.denfenceTeam.add(defenceTeam);
		this.locationBo = locationBo;

		// 初始化环境影响
		for (SoulBo soulBo : attackTeam) {
			soulBo.setHealth(soulBo.getHealth() * (100 + this.health) / 100);
			soulBo.setMagic(soulBo.getMagic() * (100 + this.magic) / 100);
			soulBo.setAttack(soulBo.getAttack() * (100 + this.attack) / 100);
			soulBo.setDenfanse(soulBo.getDenfanse() * (100 + this.denfanse) / 100);
			soulBo.setLuck(soulBo.getLuck() * (100 + this.luck) / 100);
		}

		defenceTeam.setHealth(defenceTeam.getHealth() * (100 + this.health) / 100);
		defenceTeam.setMagic(defenceTeam.getMagic() * (100 + this.magic) / 100);
		defenceTeam.setAttack(defenceTeam.getAttack() * (100 + this.attack) / 100);
		defenceTeam.setDenfanse(defenceTeam.getDenfanse() * (100 + this.denfanse) / 100);
		defenceTeam.setLuck(defenceTeam.getLuck() * (100 + this.luck) / 100);

		while (!isFinish()) {
			System.err.println("==========================防御回合开始=======================");
			System.err.println("");
			// 防御方先出手
			for (SoulBo soulBo : denfenceTeam) {
				ActionBo actionBo = soulBo.getOutPendingActionList(God.randomInt(attackTeam.size()));
				actionBoLog.add(actionBo);
				System.err.println(actionBo);
				// 普通攻击
				if (actionBo.getSkillBo() == null) {
					this.attackTeam.get(actionBo.getTarget()).hurt(actionBo.getSoulBo().getAttack());
				} else {
					// 对自身生效
					if (actionBo.getTarget() == -1) {
						soulBo.skill(actionBo.getSkillBo());
					} else {
						this.attackTeam.get(actionBo.getTarget()).skill(actionBo.getSkillBo());
					}
				}
				
				if (isFinish()) {
					break;
				}
			}
			System.err.println("");
			System.err.println("==========================防御回合结束=======================");
			System.err.println("");
			
			System.err.println("==========================攻击回合开始=======================");
			System.err.println("");
			// 攻击出手
			for (SoulBo soulBo : attackTeam) {
				ActionBo actionBo = soulBo.getOutPendingActionList(God.randomInt(denfenceTeam.size()));
				actionBoLog.add(actionBo);
				System.err.println(actionBo);
				// 普通攻击
				if (actionBo.getSkillBo() == null) {
					denfenceTeam.get(actionBo.getTarget()).hurt(actionBo.getSoulBo().getAttack());
				} else {
					// 对自身生效
					if (actionBo.getTarget() == -1) {
						soulBo.skill(actionBo.getSkillBo());
					} else {
						denfenceTeam.get(actionBo.getTarget()).skill(actionBo.getSkillBo());
					}
				}
				
				if (isFinish()) {
					break;
				}
			}
			System.err.println("");
			System.err.println("==========================攻击回合结束=======================");
		}

		System.err.println("结果===================" + (whoWin() == 1 ? "攻击" : "防御"));
		System.err.println("攻击方===================");
		for (SoulBo soulBo : this.attackTeam) {
			System.err.println(JSON.toJSONString(soulBo));
		}
		System.err.println("防御方===================");
		for (SoulBo soulBo : this.denfenceTeam) {
			System.err.println(JSON.toJSONString(soulBo));
		}

	}

	private boolean isFinish() {
		int attackNum = 0;
		for (SoulBo soulBo : attackTeam) {
			if (soulBo.getHealth() <= 0) {
				attackNum++;
			}
		}

		int defenceNum = 0;
		for (SoulBo soulBo : denfenceTeam) {
			if (soulBo.getHealth() <= 0) {
				defenceNum++;
			}
		}

		if (attackNum == attackTeam.size() || defenceNum == denfenceTeam.size()) {
			return true;
		} else {
			return false;
		}
	}

	private int whoWin() {
		int attackNum = 0;
		for (SoulBo soulBo : attackTeam) {
			if (soulBo.getHealth() <= 0) {
				attackNum++;
			}
		}

		int defenceNum = 0;
		for (SoulBo soulBo : denfenceTeam) {
			if (soulBo.getHealth() <= 0) {
				defenceNum++;
			}
		}

		if (attackNum == attackTeam.size()) {
			return 1;
		} else if (defenceNum == denfenceTeam.size()) {
			return 2;
		} else {
			return 0;
		}
	}

	public List<SoulBo> getAttackTeam() {
		return attackTeam;
	}

	public void setAttackTeam(List<SoulBo> attackTeam) {
		this.attackTeam = attackTeam;
	}

	public List<SoulBo> getDenfenceTeam() {
		return denfenceTeam;
	}

	public void setDenfenceTeam(List<SoulBo> denfenceTeam) {
		this.denfenceTeam = denfenceTeam;
	}

	public LocationBo getLocationBo() {
		return locationBo;
	}

	public void setLocationBo(LocationBo locationBo) {
		this.locationBo = locationBo;
	}

	public String getWeather() {
		return weather;
	}

	public void setWeather(String weather) {
		this.weather = weather;
	}

	public long getHealth() {
		return health;
	}

	public void setHealth(long health) {
		this.health = health;
	}

	public long getMagic() {
		return magic;
	}

	public void setMagic(long magic) {
		this.magic = magic;
	}

	public List<ActionBo> getActionBoLog() {
		return actionBoLog;
	}

	public void setActionBoLog(List<ActionBo> actionBoLog) {
		this.actionBoLog = actionBoLog;
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

}
