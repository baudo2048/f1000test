package com.f1000.test;

public class Journal {
	private String name;
	private float score;
	private boolean isReview;
	private int rank;
	
	public Journal() {}
	public Journal(String name, float score, boolean isReview) {
		super();
		this.name = name;
		this.score = score;
		this.isReview = isReview;
		this.rank = 0;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
	public boolean isReview() {
		return this.isReview;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
}
