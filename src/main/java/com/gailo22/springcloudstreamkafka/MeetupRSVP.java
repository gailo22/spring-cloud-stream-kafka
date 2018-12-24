package com.gailo22.springcloudstreamkafka;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "rsvps")
@Data
public class MeetupRSVP {
}
