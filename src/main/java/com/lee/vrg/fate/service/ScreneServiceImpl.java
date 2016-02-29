package com.lee.vrg.fate.service;

import java.util.ArrayList;
import java.util.List;

import com.lee.vrg.common.bo.LocationBo;
import com.lee.vrg.common.bo.UserBo;
import com.lee.vrg.fate.bo.BaseObject;
import com.lee.vrg.fate.bo.ScreneBo;
import com.lee.vrg.fate.bo.SkillBo;
import com.lee.vrg.fate.bo.SoulBo;

public class ScreneServiceImpl implements ScreneService {

	@Override
	public ScreneBo meet(BaseObject[] attackObjects, BaseObject denfenceObject) {
		List<SoulBo> attackTeam = new ArrayList<SoulBo>();
		for (BaseObject baseObject : attackObjects) {
			attackTeam.add(baseObject.getSoulBo());
		}
		ScreneBo screneBo = new ScreneBo(attackTeam, denfenceObject.getSoulBo(), denfenceObject.getLocations());

		return screneBo;
	}

	public static void main(String[] args) {
		List<SoulBo> attackObjects = new ArrayList<SoulBo>();
		List<SoulBo> denfenceObject = new ArrayList<SoulBo>();

		// 攻击技能
		SkillBo skillBo = new SkillBo(1L, "暴击10", "health", 1, -10, 50, "all", 0);
		List<SkillBo> attackskillBos = new ArrayList<SkillBo>();
		attackskillBos.add(skillBo);

		// 防御技能
		SkillBo skillBo2 = new SkillBo(1L, "加血10", "health", 1, 10, 50, "all", 0);
		List<SkillBo> defenceskillBos = new ArrayList<SkillBo>();
		defenceskillBos.add(skillBo);

		// 攻击方
		SoulBo attack = new SoulBo(1L, 1000, 10, 60, 100, 100, 10, attackskillBos, defenceskillBos);
		BaseObject baseObject = new BaseObject("User", 1L, new UserBo(), attack, new LocationBo());
		attackObjects.add(attack);

		// 防御方
		SoulBo defence = new SoulBo(2L, 1000, 10, 60, 100, 100, 10, attackskillBos, defenceskillBos);
		BaseObject baseObject2 = new BaseObject("User", 2L, new UserBo(), defence, new LocationBo());
		denfenceObject.add(defence);

		ScreneBo screneBo = new ScreneBo(attackObjects, defence, baseObject2.getLocations());

	}

}
