import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/"})
public class TweetGenerator extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {        
        RequestDispatcher view = request.getRequestDispatcher("tweetGenerator.jsp");
        view.forward(request, response);

    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        String twitterHandlesText = request.getParameter("twitterHandles");
        final String[] twitterHandles = twitterHandlesText.split("\\s+");

        final HashSet<String> distinctTwitterHandles = new HashSet<String>();
        for (String hashTag : twitterHandles) {
            distinctTwitterHandles.add(hashTag);
        }

        request.setAttribute("distinctTwitterHandles", distinctTwitterHandles);
        
        RequestDispatcher view = request.getRequestDispatcher("tweetGenerator.jsp");
        view.forward(request, response);
    }

}
