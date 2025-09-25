package com.example.tgcontrol.Media;

public class MediaFatec { 

		double Media; // Média final   
		double SUB;   // Prova Substitutiva   
		double X;     // Atividade extra   
		double API;   // Aprendizagem por Projeto Integrado (API)   
		double P1;    // Prova 1   
		double E1;    // Entrega E1   
		double E2;    // Entrega E2   
		 
		MediaFatec(){ 
		     
		    Media = 0.0; 
		    P1 = 0.0;     
		    E1 = 0.0;   
		    E2 = 0.0;     
		    X = 0.0;     
		    SUB = 0.0;     
		    API = 0.0;   
		} 
		 
		public MediaFatec(double P1, double E1, double E2, double X, double SUB, double API)
		{ 
		    this.P1 = P1;     
		    this.E1 = E1;   
		    this.E2 = E2;     
		    this.X = X;     
		    this.SUB = SUB;     
		    this.API = API; 
		    this.calMedia(); 
		 
		} 

		public void setSUB(double SUB) { this.SUB = SUB; } 
		public void setX(double X) { this.X = X; } 
		public void setAPI(double API) { this.API = API; } 
		public void setP1(double P1) { this.P1 = P1; } 
		public void setE1(double E1) { this.E1 = E1; } 
		public void setE2(double E2) { this.E2 = E2; } 

		public double calMedia()
		 { 

		 double base = (this.P1 * 0.5) + (this.E1 * 0.2) + (this.E2 * 0.3) + this.X + (this.SUB * 0.15);  

		   double parte1 = base * 0.5;   
		   
		    double numerador = Math.max(base - 5.9, 0);   
		    double denominador = base - 5.9;   
		   
		    double parte2 = 0;   
		        if (denominador != 0)   
		        {   
		            parte2 = (numerador / denominador) * API * 0.5;  
		        } 
		          
		    Media = parte1 + parte2; 
		     
		    if(Media > 10) 
		    { 
		        Media = 10; 
		    }

            return Media;
		}
}
