package com.driver;

import java.sql.ClientInfoStatus;
import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {

    private HashMap<String, Student> studentMap;
    private HashMap<String, Teacher> teacherMap;
    private HashMap<String, List<String>> teacherStudentMapping;

    public StudentRepository(){
        this.studentMap = new HashMap<String, Student>();
        this.teacherMap = new HashMap<String, Teacher>();
        this.teacherStudentMapping = new HashMap<String, List<String>>();
    }

    public void saveStudent(Student student){
        // your code goes here
        studentMap.put(student.getName(),student);
    }

    public void saveTeacher(Teacher teacher){
        // your code goes here
        teacherMap.put(teacher.getName(),teacher);
    }

    public void saveStudentTeacherPair(String student, String teacher){
        if(studentMap.containsKey(student) && teacherMap.containsKey(teacher)){
            teacherStudentMapping.putIfAbsent(teacher,new ArrayList<>());
            List<String> studentlist = teacherStudentMapping.get(teacher);
            if(!studentlist.contains(student))studentlist.add(student);
        }
    }

    public Student findStudent(String student){
        // your code goes here
        if(!studentMap.containsKey(student)){
            return null;

        }
        return studentMap.get(student);
    }

    public Teacher findTeacher(String teacher){
        // your code goes here
        if(!teacherMap.containsKey(teacher)){
            return null;

        }
        return teacherMap.get(teacher);
    }

    public List<String> findStudentsFromTeacher(String teacher){
        // your code goes here
        // find student list corresponding to a teacher
        if(!teacherStudentMapping.containsKey(teacher)) return null;
        return teacherStudentMapping.get(teacher);
    }

    public List<String> findAllStudents(){
        // your code goes here
        return new ArrayList<>(studentMap.keySet());
    }

    public void deleteTeacher(String teacher){
        // your code goes here
        if(teacherMap.containsKey(teacher)) teacherMap.remove(teacher);
    }

    public void deleteAllTeachers(){
        // your code goes here
        teacherMap.clear();
    }
}