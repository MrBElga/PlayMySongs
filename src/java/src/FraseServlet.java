package src;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "FraseServlet", urlPatterns = {"/FraseServlet"})
public class FraseServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String frases[]={"Não importa o que você decidiu. O que importa é que isso te faça feliz.",
                         "Algumas vezes, coisas ruins acontecem em nossas vidas para nos colocar na direção das melhores coisas que poderíamos viver.",
                         "Se a caminhada está difícil, é porque você está no caminho certo.",
                         "Você é mais corajoso do que pensa, mais forte do que parece e mais esperto do que acredita.",
                         "Pare de esperar as coisas acontecerem. Vá lá e faça com que aconteçam."};
        try (PrintWriter out = response.getWriter()) {
            Random rand = new Random();
            out.println(frases[rand.nextInt(frases.length)]);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
