public class HttpRequestIndex extends HttpRequest {
    HttpRequestIndex() {
        super();
    }
   
    public Boolean readURL(String urlIn) {
        Boolean returnValue = super.readURL(urlIn);
 
        for (String l : urlContent) {
            // trimming extra whitespaces, removing commans, beginning and ending curly barces 
            l = l.trim();
            l = l.replace("{ \"", "");
            if (l.substring(l.length() - 1).contentEquals(",")) {
                l = l.replace("\" },", "");
            }
            else {
                l = l.replace("\" }", "");
            }

            l = l.replace("\" },", "");
            String index[] = l.split("\", \"");
           
            // if there are more than one { { }...spiliting the property and value
            if (index.length > 1) {
                for (String lineIndex : index) {
                    String segments[] = lineIndex.split("\":\"");
                    
                   
                    // Searching for an https:// Url and displaying any URLs found
                    if (segments[1].toLowerCase().startsWith("https://")) {
                        HttpRequest newHttpRequest = new HttpRequest();
                        if (newHttpRequest.readURL(segments[1])) {
                            System.out.println(newHttpRequest.toString());
                        }
                        else {
                            System.out.println("Unable to access URL: " + segments[1]);
                        }
                    }
                }
            }
        }
       
        return returnValue;
    }
 }