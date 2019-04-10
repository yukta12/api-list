import java.net.*;
import java.io.*;
import java.util.*;
class ReadNews{
	/**
	*	@author     : yukta
	*	function    : readApi()
	*	Description : Reads the contents by making a http url request 
	*	@Returns    : String
	**/
	public String readApi(){
		try{
			
			/*
				Newsapi.org sets any of the following parameters 
				-country : (Mandatory)
				 Example : This parameter specifies the country from which the news is to be fetched
						   https://newsapi.org/v2/top-headlines?country=in&apiKey=2458ead0bce74439a6ebeb0579fafb14
						 
				-sources : From which source the news is to be brought 
				 Example : If you want headlines just from a specific source, for example BBC News
							https://newsapi.org/v2/top-headlines?country=in&sources=bbc-news&apiKey=2458ead0bce74439a6ebeb0579fafb14

				-q       :  search for news articles that mention a specific topic or keyword
				Example		https://newsapi.org/v2/top-headlines?country=in&q=IPL&apiKey=2458ead0bce74439a6ebeb0579fafb14
				 

				-category : search for news articles that belongs to a particular category such as tech or business may it be sports
				Example   : https://newsapi.org/v2/top-headlines?country=in&category=business&apiKey=2458ead0bce74439a6ebeb0579fafb14

				
				Use the following http connection code in your file to retrieve the json string and parse as required.
							
			*/


			//Required parameters 
			String country = "in";
			String category = "sports";
			
			//Prepare url
            URL url = new URL("https://newsapi.org/v2/top-headlines?country="+country+"&category="+category+"&apiKey=2458ead0bce74439a6ebeb0579fafb14");
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
	
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent","Chrome");
    
            int responseCode = connection.getResponseCode();
            System.out.println("response code = " + responseCode);
            if(responseCode !=200){
                System.out.println("error reading this page");
                System.out.println(connection.getResponseMessage());
                return;
            }

            BufferedReader inputStream = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			
            String line; 
            StringBuffer sb = new StringBuffer();
            while((line = inputStream.readLine()) !=null){
               sb.append(line + "\n");
            }
			       inputStream.close();

				//returning json string
            	return sb.toString();
     

            }catch(MalformedURLException e){
            System.out.println("eroor" + e.getMessage());
        }catch(IOException e){
            System.out.println("error");
        }
	}
}