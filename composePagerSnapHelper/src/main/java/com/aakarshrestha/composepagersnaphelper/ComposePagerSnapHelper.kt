package com.aakarshrestha.composepagersnaphelper

import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.Velocity

/**
 * [ComposePagerSnapHelper] is a pager style snapping in horizontal orientation.
 * Provide the width used in the item in horizontally scrolling list, and [ComposePagerSnapHelper] will calculate
 * when to snap to the target view.
 *
 * @param width width of the item in horizontally scrolling list.
 * @param content a block which describes the content. Inside this block, you will have
 * access to [NestedScrollConnection], [LazyListState] and [Dp].
 *
 * [Dp] the width of the item returned in dp.
 */

@Composable
fun ComposePagerSnapHelper(
    width: Dp,
    content: @Composable (NestedScrollConnection, LazyListState, Dp) -> Unit
) {

    val listState = rememberLazyListState()
    val widthPx = with(LocalDensity.current) { width.roundToPx() }

    val nestedScrollConnection = object : NestedScrollConnection {
        override suspend fun onPostFling(consumed: Velocity, available: Velocity): Velocity {

            val firstVisibleItemInfo = listState.layoutInfo.visibleItemsInfo.firstOrNull()
            if (firstVisibleItemInfo != null) {
                val firstItemIndex = firstVisibleItemInfo.index
                val firstItemOffset = Math.abs(firstVisibleItemInfo.offset)

                if (firstItemOffset <= widthPx / 2) {
                    listState.animateScrollToItem(firstItemIndex)
                } else {
                    listState.animateScrollToItem(firstItemIndex.plus(1))
                }
            }

            return super.onPostFling(consumed, available)
        }
    }

    content.invoke(nestedScrollConnection, listState, width)
}