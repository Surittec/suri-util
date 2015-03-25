/*
 * SURITTEC
 * Copyright 2015, SURITTEC CONSULTORIA LTDA, 
 * and individual contributors as indicated by the @authors tag
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package br.com.surittec.util.data;

/**
 * 
 * @author Lucas Lins
 *
 */
public abstract class CepUtil {
	
	/**
	 * Verifica se um objeto passado � uma {@code String} e possu� um valor v�lido para CEP.
	 * Caso seja nulo, leva em considera��o o par�metro {@code nullable} passado.
	 * 
	 * @param value
	 * @return
	 */
	public static boolean isValid(Object value) {
		return isValid(value, false);
	}

	/**
	 * Verifica se um objeto passado � uma {@code String} e possu� um valor v�lido para CEP.
	 * Caso seja nulo, leva em considera��o o par�metro {@code nullable} passado.
	 * 
	 * @param value
	 * @return
	 */
	public static boolean isValid(Object value, boolean nullable) {
		if(!nullable && value == null) return false;

		if(nullable && value == null) return true;
		
		if (value != null && !value.toString().matches("^\\d{8}$")) {
			return false;
		}else{
			return true;
		}
	}
	
	/**
	 * Inclu� a m�scara padr�o para CEP: 99999-999
	 * 
	 * @param cnpj
	 * @return
	 */
	public static String format(String cep){
		if(cep == null) return null;
		
		if (cep.length() == 9 || cep.length() < 8) {
			return cep;
		}else {
			return cep.substring(0, cep.length() - 3) + "-" + cep.substring(cep.length() - 3);
		}
	}
	
	/**
	 * Remove a m�scara padr�o para CEP, deixando apenas os n�meros.
	 * 
	 * @param value
	 * @return
	 */
	public static String unformat(String value){
		if(value == null || value.trim().equals("")) return null;
		return value.replace("-", "");
	}
	
}
