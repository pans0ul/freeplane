/*
 *  Freeplane - mind map editor
 *  Copyright (C) 2009 Tamas Eppel
 *
 *  This file author is Tamas Eppel
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 2 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.freeplane.core.icon;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.freeplane.core.resources.ResourceController;
import org.freeplane.core.util.LogTool;

/**
 * 
 * Represents all icons used in Freeplane
 * 
 * @author Tamas Eppel
 *
 */
public class UserIcon extends MindIcon {

	public UserIcon(final String name, final String fileName, final String description) {
		super(name, fileName, description);
	}
	@Override
	public String getPath() {
		final StringBuilder builder = new StringBuilder();
		builder.append(ResourceController.getResourceController().getFreeplaneUserDirectory());
		builder.append(SEPARATOR);
		builder.append("icons");
		builder.append(SEPARATOR);
		builder.append(this.getFileName());
		String path = builder.toString().replace(File.separatorChar, '/');
		return path;
	}
	@Override
	public URL getUrl() {
		
		URL result = null;
		String urlString = getPath();
		try {
			result = new File(urlString).toURI().toURL();
		} catch (MalformedURLException e) {
			LogTool.warn(String.format("could not create URL from [%s]", urlString));
		}
		
		return result;
	}
}