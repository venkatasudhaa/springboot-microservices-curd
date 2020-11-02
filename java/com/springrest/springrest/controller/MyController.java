package com.springrest.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.entity.Course;
import com.springrest.springrest.services.CourseService;

@RestController
public class MyController {
	// dependency injection is use here , and create object its self.
	@Autowired
	private CourseService courseService;

	@GetMapping("/string")
	public String home() {
		return "sudha";
	}

	// get the courses 
		@GetMapping("/courses")
		public List<Course> getCourse() {
			return this.courseService.getCouses();
		}

		// get course with id
		@GetMapping("/courses/{courseId}")
		public ResponseEntity<Object> getSingleCourse(@PathVariable String courseId) {
			Course course = this.courseService.getCourse(courseId);
			
			if(course!=null) {
			return new ResponseEntity<Object>(course, HttpStatus.OK);}
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}

		// post course
		@PostMapping("/courses/send")
		public ResponseEntity<HttpStatus> addCourseRequest(@RequestBody Course course) {
			if (course != null) {
				courseService.addCourse(course);
				return new ResponseEntity<>(HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		}

		// Update Course using Put Method
		@PutMapping("/courses/udpate")
		public ResponseEntity<HttpStatus> UpdateRequest(@RequestBody Course course) {
			if (course != null) {
				courseService.updateCourse(course);
				return new ResponseEntity<>(HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		// delete the course
		@DeleteMapping("/courses/{courseId}")
		public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId) {
			try {
				this.courseService.deleteCourse(courseId);
				return new ResponseEntity<>(HttpStatus.OK);
			} catch (Exception e) {
			}
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
