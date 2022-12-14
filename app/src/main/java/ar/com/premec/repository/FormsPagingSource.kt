package ar.com.premec.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import ar.com.premec.data.FormDAO
import ar.com.premec.data.model.Form

//TODO modify this class when the sqlite is enabled
class FormsPagingSource(
    //TODO inject the dao with hilt
    val formDAO: FormDAO,
    //TODO we probably don't need this parameter
    val query: String
) : PagingSource<Int, Form>() {

    override suspend fun load(
        params: LoadParams<Int>
    ): LoadResult<Int, Form> {
        try {
            //TODO pages go from 1 to 3 as it's a test set.
            val nextPageNumber = params.key ?: 1
            val forms = formDAO.get(query, nextPageNumber)
            return LoadResult.Page(
                data = forms,
                prevKey = null, // Only paging forward.
                nextKey = nextPageNumber + 1
            )
        } catch (e: Exception) {
            //TODO test and handle exceptions on the UI side
            return LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Form>): Int? {
        //TODO double check this method
        return 1

        /*
        // Try to find the page key of the closest page to anchorPosition, from
        // either the prevKey or the nextKey, but you need to handle nullability
        // here:
        //  * prevKey == null -> anchorPage is the first page.
        //  * nextKey == null -> anchorPage is the last page.
        //  * both prevKey and nextKey null -> anchorPage is the initial page, so
        //    just return null.
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }

         */
    }
}