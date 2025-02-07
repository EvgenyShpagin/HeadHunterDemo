package com.demo.hh.core.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import com.demo.hh.core.model.Date
import com.demo.hh.core.model.Experience
import com.demo.hh.core.model.Salary

@Composable
fun Experience.asString(): String {
    return stringResource(
        when (this) {
            Experience.None -> R.string.experience_none
            Experience.From1To3Years -> R.string.experience_1_to_3_years
            Experience.From3To6Years -> R.string.experience_3_to_6_years
            Experience.From6Years -> R.string.experience_from_6_years
        }
    )
}

@Composable
fun Date.asString(): String {
    val months = stringArrayResource(R.array.publish_date_suffix_month)
    return stringResource(
        R.string.publish_date,
        dayOfMonth,
        months[month - 1]
    )
}

@Composable
fun Salary.asString(): String {
    return when (this) {
        is Salary.Exact -> stringResource(R.string.salary_exact, amount, currencySign)
        is Salary.Range -> when {
            fromAmount != null && toAmount != null ->
                stringResource(R.string.salary_range, fromAmount!!, toAmount!!, currencySign)

            fromAmount != null ->
                stringResource(R.string.salary_range_from, fromAmount!!, currencySign)

            toAmount != null ->
                stringResource(R.string.salary_range_to, toAmount!!, currencySign)

            else -> stringResource(R.string.salary_not_specified)
        }

        Salary.Unspecified -> stringResource(R.string.salary_not_specified)
    }
}
