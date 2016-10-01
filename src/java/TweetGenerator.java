
import java.io.IOException;
import java.util.ArrayList;
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

        if (request.getParameter("tweetHandles") != null) {

            HashSet<String> set = getHandleSet(request, "tweetHandles");
            String headline = request.getParameter("headline");

            int spaceLeft = 139 - headline.length();

            ArrayList<String> tweets = new ArrayList<String>();
            tweets.add(headline);
            int tweetIndex = 0;
            int currentSpaceLeft = spaceLeft;
            for (String handle : set) {
                if (currentSpaceLeft > handle.length() + 1) {
                    tweets.set(tweetIndex, handle + " " + tweets.get(tweetIndex));
                    currentSpaceLeft -= (handle.length() + 1);
                } else {
                    currentSpaceLeft = spaceLeft;
                    tweets.add(headline);
                    tweetIndex++;
                }
            }
            request.setAttribute("tweets", tweets);

            RequestDispatcher view = request.getRequestDispatcher("tweetGenerator.jsp");
            view.forward(request, response);
        } else {

            request.setAttribute("distinctTwitterHandles", getHandleSet(request, "twitterHandles"));

            RequestDispatcher view = request.getRequestDispatcher("tweetGenerator.jsp");
            view.forward(request, response);
        }
    }

    private HashSet<String> getHandleSet(HttpServletRequest request, String text) {
        String twitterHandlesText = request.getParameter(text);
        final String[] twitterHandles = twitterHandlesText.split("\\s+");

        HashSet<String> distinctTwitterHandles = new HashSet<String>();
        for (String hashTag : twitterHandles) {
            distinctTwitterHandles.add(hashTag);
        }
        return distinctTwitterHandles;
    }

}
