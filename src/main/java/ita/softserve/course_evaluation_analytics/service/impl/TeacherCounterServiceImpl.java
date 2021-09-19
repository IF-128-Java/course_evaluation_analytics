package ita.softserve.course_evaluation_analytics.service.impl;

import ita.softserve.course_evaluation_analytics.entity.TeacherRateCounter;
import ita.softserve.course_evaluation_analytics.entity.Users;
import ita.softserve.course_evaluation_analytics.repository.TeacherRepository;
import ita.softserve.course_evaluation_analytics.repository.UsersRepository;
import ita.softserve.course_evaluation_analytics.service.TeacherCounterService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TeacherCounterServiceImpl implements TeacherCounterService {
	
	private final TeacherRepository teacherRepository;
	private final UsersRepository usersRepository;
	
	public TeacherCounterServiceImpl(TeacherRepository teacherRepository, UsersRepository usersRepository) {
		this.teacherRepository = teacherRepository;
		this.usersRepository = usersRepository;
	}
	
	@Override
	public List<TeacherRateCounter> getTeacherRate() {
		List<Long> teacherIds = teacherRepository.getAllTeacher();
		List<TeacherRateCounter> teacherRateCounters = new ArrayList<>();
		teacherIds.forEach(teacherId -> teacherRateCounters.add(new TeacherRateCounter(getTeacherName(teacherId), getTeacherCourses(teacherId), getTeachersRate(teacherId))));
		return teacherRateCounters;
	}
	
	private List<Long> getTeacherCourses(Long teacherId) {
		return teacherRepository.getAllTeacherCourses(teacherId);
	}
	
	private Float getTeachersRate(Long teacherId) {
		Optional<Float> optional = teacherRepository.getTeachersRate(teacherId);
		return optional.orElse(0f);
	}
	
	private String getTeacherName(Long teacherId) {
		Users users = usersRepository.findUserById(teacherId);
		return users.getFirstName() + " " + users.getLastName();
	}
}
