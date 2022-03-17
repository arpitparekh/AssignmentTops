package com.example.assignmenttops.xmlParsing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.example.assignmenttops.databinding.ActivityXmlParsingBinding;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class XmlParsingActivity extends AppCompatActivity {
    private ActivityXmlParsingBinding binding;
    private String newsUrl="https://www.feedforall.com/sample.xml";
    private ArrayList<News>newsArrayList;
    private News theNews;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityXmlParsingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        NewsAsyncTask asyncTask=new NewsAsyncTask();
        asyncTask.execute();

    }
    class NewsAsyncTask extends AsyncTask<String,Void,String>
    {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            newsArrayList=new ArrayList<>();
        }

        @Override
        protected String doInBackground(String... strings) {
            doXmlParsing();
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            ArrayAdapter<News>arrayAdapter=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,newsArrayList);
            binding.ListViewNews.setAdapter(arrayAdapter);
        }
    }

    private void doXmlParsing() {
        SAXParserFactory factory=SAXParserFactory.newInstance();
        try{
            SAXParser parser=factory.newSAXParser();
            DefaultHandler handler=new DefaultHandler(){
                boolean bTitle,bDescription;

                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    super.startElement(uri, localName, qName, attributes);
                    if(localName.equals("title")){
                        bTitle=true;
                        theNews=new News();

                    }else if(localName.equals("description")){
                        bDescription=true;
                    }

                }

                @Override
                public void characters(char[] ch, int start, int length) throws SAXException {
                    super.characters(ch, start, length);
                    if(bTitle){
                        theNews.setTitle(new String(ch,start,length));
                    }else if(bDescription){
                        theNews.setDescription(new String(ch,start,length));
                    }
                }

                @Override
                public void endElement(String uri, String localName, String qName) throws SAXException {
                    super.endElement(uri, localName, qName);
                    if(localName.equals("title")){
                        bTitle=false;
                    }else if(localName.equals("description")){
                        bDescription=false;
                        newsArrayList.add(theNews);
                    }

                }
            };
            parser.parse(newsUrl,handler);
        }catch (Exception e){
            Log.i("exception",e.toString());
        }
    }
}