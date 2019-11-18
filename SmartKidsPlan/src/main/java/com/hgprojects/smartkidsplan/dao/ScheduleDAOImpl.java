package com.hgprojects.smartkidsplan.dao;

import java.time.LocalTime;
import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hgprojects.smartkidsplan.entity.Register;
import com.hgprojects.smartkidsplan.entity.Schedule;

@Repository
public class ScheduleDAOImpl implements ScheduleDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Schedule> getSchedules() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = currentSession.createQuery("from Schedule order by dayOfWeek");
		List<Schedule> schedules = theQuery.getResultList();
		return schedules;
	}

	@Override
	public void saveSchedule(Schedule theSchedule) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(theSchedule);
	}

	@Override
	public void deleteSchedule(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = currentSession.createQuery("delete from Schedule where id=:scheduleId");
		theQuery.setParameter("scheduleId", theId);
		theQuery.executeUpdate();
	}

	@Override
	public Schedule getSchedule(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Schedule tempSchedule = currentSession.get(Schedule.class, theId);
		return tempSchedule;
	}

	@Override
	public List<Schedule> searchSchedule(String theSearchName) {
	Session currentSession = sessionFactory.getCurrentSession();
		
		Query theQuery = null;
		
		if(theSearchName != null && theSearchName.trim().length() > 0 ) {
			theQuery = currentSession.createQuery("from Schedule where lower(name) like :theName "
					+ "or lower(description) like :theName "
					+ "or startTime like :theName "
					+ "or endTime like :theName "
					+ "or dayOfWeek like :theName "
					+ "or teacher.firstName like :theName "
					+ "or teacher.lastName like :theName "
				, Schedule.class);
			theQuery.setParameter("theName", "%"+theSearchName.toLowerCase()+"%");
			}
		else {
			//search name is empty so just get all schedules
			theQuery = currentSession.createQuery("from Schedule",Schedule.class);
		}
		
		//execute the query
		List<Schedule> schedules = theQuery.getResultList();
		
		return schedules;
	}

	@Override
	public List<Schedule> getDailySchedules(int dayOfWeek) {
		Session currentSession = sessionFactory.getCurrentSession();
		LocalTime theEndTime = LocalTime.of(16, 0);
		Query theQuery = currentSession.createQuery("from Schedule where dayOfWeek=:theDayOfWeek and endTime=:theEndTime order by teacher.lastName",Schedule.class);
		theQuery.setParameter("theDayOfWeek", dayOfWeek);
		theQuery.setParameter("theEndTime", theEndTime);
		List<Schedule> dailySchedules = theQuery.getResultList();
		return dailySchedules;
	}
	
	
	

}
