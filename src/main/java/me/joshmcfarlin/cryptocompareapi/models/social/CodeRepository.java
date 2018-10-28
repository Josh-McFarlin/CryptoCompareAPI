package me.joshmcfarlin.cryptocompareapi.models.social;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Represents social data from a code repository
 */
public class CodeRepository {
	/**
	 * A list of code repository objects
	 */
	@SerializedName("List")
	private List<CodeEntry> list;

	/**
	 * The number of points
	 */
	@SerializedName("Points")
	private int points;

	/**
	 * {@link CodeRepository#list}
	 */
	public List<CodeEntry> getList() {
		return list;
	}

	/**
	 * {@link CodeRepository#points}
	 */
	public int getPoints() {
		return points;
	}

}