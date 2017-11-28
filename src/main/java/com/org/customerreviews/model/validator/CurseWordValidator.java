package com.org.customerreviews.model.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;

import com.org.customerreviews.constants.ProductReviewConstant;



public class CurseWordValidator implements ConstraintValidator<NoCurseWord, String> {

	@Autowired
	MessageSourceAccessor messageSourceAccessor;

	String[] curseWords;


	@Override
	public void initialize(NoCurseWord noCurseWord) {
		if(messageSourceAccessor!=null)

		curseWords = messageSourceAccessor.getMessage(ProductReviewConstant.CURSE_WORDS_KEY).intern().split("\\s*,\\s*");

	}

	@Override
	public boolean isValid(String comment, ConstraintValidatorContext arg1) {
		if (comment != null && comment.length() > 0 && curseWords != null && curseWords.length > 0) {

			for (String s : curseWords) {
				
				if (comment.toLowerCase().contains(s))

					return false;

			}

		}

		return true;
	}

}
