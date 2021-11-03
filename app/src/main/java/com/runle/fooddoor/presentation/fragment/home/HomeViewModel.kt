package com.runle.fooddoor.presentation.fragment.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.runle.fooddoor.R
import com.runle.fooddoor.model.*
import com.runle.fooddoor.provider.DataProvider
import com.runle.fooddoor.viewmodel.itemviewmodel.*
import kotlinx.coroutines.launch

class HomeViewModel(var dataProvider: DataProvider): ViewModel() {

    companion object {
        const val HEADER_ITEM = 0
        const val LISTING_ITEM = 1
    }

    val popularData: LiveData<List<ItemViewModel>> get() = _popularData
    private val _popularData = MutableLiveData<List<ItemViewModel>>(emptyList())

    val eventsPopular: LiveData<Event<ItemListEvent>> get() = _eventsPopular
    private val _eventsPopular = MutableLiveData<Event<ItemListEvent>>()


    val bannerData: LiveData<List<ItemViewModel>> get() = _bannerData
    private val _bannerData = MutableLiveData<List<ItemViewModel>>(emptyList())

    val eventsBanner: LiveData<Event<ItemListEvent>> get() = _eventsBanner
    private val _eventsBanner = MutableLiveData<Event<ItemListEvent>>()

    val categoryData: LiveData<List<ItemViewModel>> get() = _categoryData
    private val _categoryData = MutableLiveData<List<ItemViewModel>>(emptyList())

    val eventsCategory: LiveData<Event<ItemListEvent>> get() = _eventsCategory
    private val _eventsCategory = MutableLiveData<Event<ItemListEvent>>()

    val voucherData: LiveData<List<ItemViewModel>> get() = _voucherData
    private val _voucherData = MutableLiveData<List<ItemViewModel>>(emptyList())

    val eventsVoucher: LiveData<Event<ItemListEvent>> get() = _eventsVoucher
    private val _eventsVoucher = MutableLiveData<Event<ItemListEvent>>()


    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            // create banner list

            val bannerList = dataProvider.getBannerListData()

            val bannerById = bannerList.groupBy { it.id }

            val bannerViewData = createBannerViewData(bannerById)
            _bannerData.postValue(bannerViewData)

            // create popular list
            val popularList = dataProvider.getPopularListData()

            val popularById = popularList.groupBy { it.title }

            val viewData = createViewData(popularById)
            _popularData.postValue(viewData)

            // create category list

            val categoryList = dataProvider.getCategoryListData()

            val categoryById = categoryList.groupBy { categoryModel->
                categoryModel.id }

            val categoryViewData = createCategoryViewData(categoryById)
            _categoryData.postValue(categoryViewData)


            // create category list

            val voucherList = dataProvider.getVoucherListData()

            val voucherById = voucherList.groupBy { voucher->
                voucher.id }

            val voucherViewData = createVoucherViewData(voucherById)
            _voucherData.postValue(voucherViewData)

        }
    }

    private fun createBannerViewData(bannerById: Map<Int?, List<BannerModel>>): List<ItemViewModel> {
        val viewData = mutableListOf<ItemViewModel>()
        bannerById.keys.forEach {
            bannerById[it]?.forEach {bannerModel: BannerModel ->
                viewData.add(ItemListingViewModel(bannerModel, R.layout.partial_item_banner,
                    LISTING_ITEM,:: onBannerItemListingClicked))
            }
        }

        return viewData
    }

    private fun createViewData(popularById: Map<String, List<PopularModel>>): List<ItemViewModel> {
        val viewData = mutableListOf<ItemViewModel>()
        popularById.keys.forEach {
            val popularItems = popularById[it]
            popularItems?.forEach {popularItem: PopularModel ->
                val item = if (popularItem.isHeader) {
                    HeaderViewModel("Popular",popularItem)
                } else {
                    ItemListingViewModel(popularItem,R.layout.partial_item_popular, LISTING_ITEM, ::onPopularItemListingClicked)
                }
                viewData.add(item)
            }
        }

        return viewData
    }

    private fun createCategoryViewData(categoryById: Map<Long?, List<CategoryModel>>): List<ItemViewModel> {
        val viewData = mutableListOf<ItemViewModel>()
        categoryById.keys.forEach {
            categoryById[it]?.forEach {categoryModel: CategoryModel ->
                viewData.add(ItemListingViewModel(categoryModel,R.layout.partial_item_category,
                    LISTING_ITEM,:: onCategoryItemListingClicked))
            }
        }

        return viewData
    }


    private fun createVoucherViewData(voucherById: Map<Int?, List<VoucherModel>>): List<ItemViewModel> {
        val viewData = mutableListOf<ItemViewModel>()
        voucherById.keys.forEach {
            voucherById[it]?.forEach {voucher: VoucherModel ->
                viewData.add(ItemListingViewModel(voucher,R.layout.partial_item_voucher,
                    LISTING_ITEM,:: onVoucherItemListingClicked))
            }
        }

        return viewData
    }

    private fun onPopularItemListingClicked(model: Any) {
        _eventsPopular.postValue(Event(ItemListEvent.ShowSelectedModel(model)))
    }

    private fun onBannerItemListingClicked(model: Any) {
        _eventsBanner.postValue(Event(ItemListEvent.ShowSelectedModel(model)))
    }

    private fun onCategoryItemListingClicked(model: Any) {
        _eventsCategory.postValue(Event(ItemListEvent.ShowSelectedModel(model)))
    }

    private fun onVoucherItemListingClicked(model: Any) {
        _eventsVoucher.postValue(Event(ItemListEvent.ShowSelectedModel(model)))
    }

}