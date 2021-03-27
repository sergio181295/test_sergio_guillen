package com.guillen.entity;

import java.util.Map;

public class TvMazeResponse {

	Double score;
	Map<String, Object> show;

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public Map<String, Object> getShow() {
		return show;
	}

	public void setShow(Map<String, Object> show) {
		this.show = show;
	}
}
