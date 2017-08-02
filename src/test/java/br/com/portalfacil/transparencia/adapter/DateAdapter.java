package br.com.portalfacil.transparencia.adapter;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

public class DateAdapter extends TypeAdapter<Date> {

    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public Date read(JsonReader in) throws IOException {
	if (in.peek() == JsonToken.NULL) {
	    in.nextNull();
	    return null;
	}
	return deserializeToDate(in.nextString());
    }

    private synchronized Date deserializeToDate(String json) {
	try {
	    return sdf.parse(json);
	} catch (ParseException e) {
	    //throw new JsonSyntaxException(json, e);
	    return null;
	}
    }

    @Override
    public synchronized void write(JsonWriter out, Date value) throws IOException {
	if (value == null) {
	    out.nullValue();
	    return;
	}
	String dateFormatAsString = sdf.format(value);
	out.value(dateFormatAsString);
    }

}
