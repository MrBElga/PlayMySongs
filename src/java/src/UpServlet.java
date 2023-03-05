
package src;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig(
    location="/", 
    fileSizeThreshold=1024*1024,    // 1MB *      
    maxFileSize=1024*1024*100,      // 100MB **
    maxRequestSize=1024*1024*10*10  // 100MB ***
)


@WebServlet(name = "UpServlet", urlPatterns = {"/UpServlet"})
public class UpServlet extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String pasta = "tmp";
        Part filePart = request.getPart("file");  // Lê o arquivo de upload
        String fileName = request.getParameter("nMusica");
        fileName = fileName+"_"+request.getParameter("estilo")+"_"+request.getParameter("nArtist");
        OutputStream out = null; InputStream filecontent = null;

        try {  //criando a pasta
            File fpasta = new File(getServletContext().getRealPath("/") + "/" + pasta);
            fpasta.mkdir();
            out = new FileOutputStream(new File(fpasta.getAbsolutePath() + "/" + fileName));
            filecontent = filePart.getInputStream();
            int read = 0;
            byte[] bytes = new byte[1024];
            while ((read = filecontent.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            response.getWriter().println("Novo arquivo " + fileName + " criado na pasta " + pasta);
            out.close();
            filecontent.close();
            response.getWriter().close();
        } catch (Exception fne) {
            
      
            response.getWriter().println("Erro ao receber o arquivo");
            response.getWriter().println("<br/> ERRO: " + fne.getMessage());
            response.getWriter().close();
            response.sendRedirect("index.html?mens=erro");
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
