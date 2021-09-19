package ita.softserve.course_evaluation_analytics.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TeacherRateCounter {
	private String teacher;
	private float teacherRate;
}
