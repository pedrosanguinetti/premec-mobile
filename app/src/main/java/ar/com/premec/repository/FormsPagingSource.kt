package ar.com.premec.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import ar.com.premec.data.FormDAO
import ar.com.premec.data.model.Form
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Thread.sleep

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
        return withContext(Dispatchers.IO) {
            try {
                //TODO pages go from 1 to 3 as it's a test set.
                //TODO remove the following sleep. It's just for UI testing purposes
                sleep(1000)
                val page = params.key ?: 1
                val forms = formDAO.get(query, page)
                var nextPageNumber: Int? = null
                if (forms.isNotEmpty()) {
                    nextPageNumber = page + 1
                }
                return@withContext LoadResult.Page(
                    data = forms,
                    prevKey = null, // Only paging forward.
                    nextKey = nextPageNumber
                )
            } catch (e: Exception) {
                //TODO test and handle exceptions on the UI side
                return@withContext LoadResult.Error(e)
            }
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