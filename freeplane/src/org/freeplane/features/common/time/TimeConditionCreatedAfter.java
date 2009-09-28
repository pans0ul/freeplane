/*
 *  Freeplane - mind map editor
 *  Copyright (C) 2009 Dimitry Polivaev
 *
 *  This file author is Dimitry Polivaev
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
package org.freeplane.features.common.time;

import java.util.Date;

import org.freeplane.core.filter.condition.ConditionFactory;
import org.freeplane.core.filter.condition.ICondition;
import org.freeplane.core.modecontroller.ModeController;
import org.freeplane.core.model.NodeModel;
import org.freeplane.core.resources.ResourceBundles;

/**
 * @author Dimitry Polivaev
 * Mar 5, 2009
 */
class TimeConditionCreatedAfter extends TimeConditionCreatedBefore implements ICondition {
	static final String NAME = "time_condition_created_after";

	public TimeConditionCreatedAfter(final Date date) {
		super(date);
	}

	@Override
	public boolean checkNode(ModeController modeController, final NodeModel node) {
		return !super.checkNode(modeController, node);
	}

	@Override
	protected String createDesctiption() {
		final String filterTime = ResourceBundles.getText(TimeConditionController.FILTER_TIME);
		final String dateAsString = TimeCondition.format(getDate());
		final String before = ResourceBundles.getText(FILTER_CREATED_AFTER);
		return ConditionFactory.createDescription(filterTime, before, dateAsString, false);
	}

	@Override
	String getName() {
		return NAME;
	}
}
