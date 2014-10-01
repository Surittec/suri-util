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
 * @author Lucas Lins
 *
 */
public class Message {

	private String code;
	private String component;
	
	private String message;
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
