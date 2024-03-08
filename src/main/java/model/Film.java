package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Film {

	private int film_Id;

	private String title;

	private String description;

	private int release_year;

	private int language_id;

	private int rental_duration;

	private double rental_rate;

	private int length;

	private double replacement_cost;

	private String rating;

	private Timestamp last_update;

	private String special_features;

	private String fulltext;

}
