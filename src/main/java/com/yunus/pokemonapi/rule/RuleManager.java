package com.yunus.pokemonapi.rule;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.Getter;

@Getter
@Component
public class RuleManager {

	private List<BaseRule> ruleList;

	public RuleManager(List<BaseRule> ruleList) {
		this.ruleList = ruleList;
	}

	public void addRule(BaseRule rule) {
		ruleList.add(rule);
	}

	public void remove(BaseRule rule) {
		ruleList.remove(rule);
	}

}
