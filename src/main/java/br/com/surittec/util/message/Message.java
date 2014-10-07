/*
 * SURITTEC
 * Copyright 2014, SURITTEC CONSULTORIA LTDA, 
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
package br.com.surittec.util.message;

/**
 * 
 * Classe que permite a passagem de mensagens na aplicação, por exemplo, dentro de exceções.
 * 
 * {@link br.com.surittec.util.message.Message#code}
 * {@link br.com.surittec.util.message.Message#component}
 * {@link br.com.surittec.util.message.Message#message}
 * {@link br.com.surittec.util.message.Message#messageParams}
 * 
 * @author Lucas Lins
 * 
 */
public class Message {

	/**
	 * Código da mensagem. Identifica unicamente a mensagem e pode ser utilizado para referencia-las
	 * em diferentes sistemas.
	 */
	private String code;

	/**
	 * Campo referenciado pela mensagem. Pode ser, por exemplos, um ID de campo no JSF ou um parâmetro
	 * de Web Service.
	 */
	private String component;

	/**
	 * Mensagem padrão. Essa mensagem pode ser alterada baseando-se no identificador, campo {@code code}.
	 */
	private String message;

	/**
	 * Lista com os parâmetros da mensagem. Caso a mensagem receba parâmetros para ser personalizada,
	 * essa lista é que conterá esses parâmetros.
	 */
	private Object[] messageParams;

	/*
	 * Constructors
	 */

	public Message(String code, String component, String message, Object[] messageParams) {
		this.code = code;
		this.component = component;
		this.message = message;
		this.messageParams = messageParams;
	}

	/*
	 * Gets & Sets
	 */

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getComponent() {
		return component;
	}

	public void setComponent(String component) {
		this.component = component;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object[] getMessageParams() {
		return messageParams;
	}

	public void setMessageParams(Object[] messageParams) {
		this.messageParams = messageParams;
	}

}
