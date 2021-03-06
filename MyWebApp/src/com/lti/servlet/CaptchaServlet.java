package com.lti.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CaptchaServlet
 */
@WebServlet("/captcha.jpg")
public class CaptchaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"; //declare the string
		
		String captcha = " ";
		for (int i = 0; i < 5; i++) {
			int rno = (int) Math.floor(Math.random() * str.length()); // multiply by higher number//
			captcha += str.charAt(rno);
		}
		// random numbers can be also generated by java.util.package//

		response.setContentType("image/jpeg"); //send image in response
		ServletOutputStream out = response.getOutputStream();  //obtain the response image

		BufferedImage img = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB); //image create in memory(100,100)(x,y)co-ordinates
		Graphics g = img.getGraphics(); //brush as in paint

		g.setColor(Color.BLUE);
		g.fillRect(0, 0, 100, 100);
		g.setColor(Color.YELLOW);
		g.setFont(new Font("Harrington", Font.BOLD, 28));
		g.drawString(captcha, 5, 45);											

		ImageIO.write(img, "jpeg", out); //converted the img in jpeg" format imageIO is java library
	}
}
