package com.epam.creator;

import com.epam.builder.LiqueurBuilder;
import com.epam.liquer.Liqueur;

public interface AbstractLiqueurFromBuilderCreator {

	Liqueur createLiqueur(LiqueurBuilder builder);
}
