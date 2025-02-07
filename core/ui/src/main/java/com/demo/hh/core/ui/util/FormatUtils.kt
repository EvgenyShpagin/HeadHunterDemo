package com.demo.hh.core.ui.util

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.demo.hh.core.model.Date
import com.demo.hh.core.model.Experience
import com.demo.hh.core.model.Salary
import com.demo.hh.core.ui.R

fun Experience.toString(context: Context): String {
    return context.getString(
        when (this) {
            Experience.None -> R.string.experience_none
            Experience.From1To3Years -> R.string.experience_1_to_3_years
            Experience.From3To6Years -> R.string.experience_3_to_6_years
            Experience.From6Years -> R.string.experience_from_6_years
        }
    )
}

fun Date.toString(context: Context): String {
    val months = context.resources.getStringArray(R.array.publish_date_suffix_month)
    return context.getString(
        R.string.publish_date,
        dayOfMonth,
        months[month - 1]
    )
}

fun Salary.toString(context: Context): String {
    return when (this) {
        is Salary.Exact -> context.getString(R.string.salary_exact, amount, currencySign)
        is Salary.Range -> when {
            fromAmount != null && toAmount != null ->
                context.getString(R.string.salary_range, fromAmount!!, toAmount!!, currencySign)

            fromAmount != null ->
                context.getString(R.string.salary_range_from, fromAmount!!, currencySign)

            toAmount != null ->
                context.getString(R.string.salary_range_to, toAmount!!, currencySign)

            else -> context.getString(R.string.salary_not_specified)
        }

        Salary.Unspecified -> context.getString(R.string.salary_not_specified)
    }
}

@Composable
internal fun Experience.asString(): String {
    val context = LocalContext.current
    return toString(context)
}

@Composable
internal fun Date.asString(): String {
    val context = LocalContext.current
    return toString(context)
}

@Composable
internal fun Salary.asString(): String {
    val context = LocalContext.current
    return toString(context)
}
