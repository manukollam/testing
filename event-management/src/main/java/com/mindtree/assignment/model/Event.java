package com.mindtree.assignment.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "events")
public class Event {

   @Id
   @Column(name = "event_id")
   private Long eventId;

   @Column(name = "event_title", unique = true)
   @Size(max = 100, min = 3, message = "{event.name.invalid}")
   @NotEmpty(message="Please enter valid event name")
   private String eventTitle;

   @Column(name = "description")
   @Size(max = 1000, min = 3, message = "{event.description.invalid}")
   @NotEmpty(message="Please provide valid description")
   private String description;

	public Long getEventId() {
		return eventId;
	}
	
	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}
	
	public String getEventTitle() {
		return eventTitle;
	}
	
	public void setEventTitle(String eventTitle) {
		this.eventTitle = eventTitle;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Event))
            return false;

        Event event = (Event) o;
        if (eventId != event.eventId)
            return false;
        if (!eventTitle.equals(event.eventTitle))
            return false;
        if (!description.equals(event.description))
            return false;
       return true;
    }

    @Override
    public int hashCode() {
        int result = eventId.intValue();
        result = 31 * result + eventTitle.hashCode();
        result = 31 * result + description.hashCode();
       return result;
    }
}