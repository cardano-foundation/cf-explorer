package util;

import groovy.lang.Tuple2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CreateParameters {
    public Map<String, Object> getParamsMap() {
        return paramsMap;
    }

    private Map<String, Object> paramsMap;

    public CreateParameters() {
        paramsMap = new HashMap<>();
    }

    public CreateParameters withKeyword(String keyword) {
        paramsMap.put("keyword", keyword);
        paramsMap.put("keyWord", keyword);
        return this;
    }

    public CreateParameters withPage(String page) {
        paramsMap.put("page", page);
        return this;
    }

    public CreateParameters withPage(Object page) {
        paramsMap.put("page", page);
        return this;
    }

    public CreateParameters withNameEvent(Object nameEvent) {
        paramsMap.put("eventName", nameEvent);
        return this;
    }

    public CreateParameters withNameAttribute(Object nameAttribute) {
        paramsMap.put("attributeName", nameAttribute);
        return this;
    }

    public CreateParameters withPage(Integer page) {
        paramsMap.put("page", page);
        return this;
    }

    public CreateParameters withPageSize(Object pageSize) {
        paramsMap.put("size", pageSize);
        return this;
    }
    public CreateParameters withSort(ArrayList<String> sort){
        paramsMap.put("sort", sort.get(0));
        paramsMap.put("sort", sort.get(1));
        return this;
    }

    public CreateParameters withStartCount(Integer startCount) {
        paramsMap.put("startCount", startCount);
        return this;
    }

    public CreateParameters withEndCount(Integer endCount) {
        paramsMap.put("endCount", endCount);
        return this;
    }

    public CreateParameters withTopicName(String topicName) {
        paramsMap.put("topicName", topicName);
        return this;
    }

    public CreateParameters withPerPage(String perPage) {
        paramsMap.put("perPage", perPage);
        return this;
    }

    public CreateParameters withSortDate(String sortDate) {
        paramsMap.put("sortDate", sortDate);
        return this;
    }

    public CreateParameters withSortType(String sortType) {
        paramsMap.put("sortType", sortType);
        return this;
    }

    public CreateParameters withSortBy(String sortBy) {
        paramsMap.put("sortBy", sortBy);
        return this;
    }

    public CreateParameters withSortField(String sortField) {
        paramsMap.put("sortField", sortField);
        return this;
    }

    public CreateParameters withOrderBy(String orderBy) {
        paramsMap.put("orderBy", orderBy);
        return this;
    }

    public CreateParameters withDiscountType(String discountType) {
        paramsMap.put("discountType", discountType);
        return this;
    }

    public CreateParameters withShiftId(String ShiftId) {
        paramsMap.put("shiftId", ShiftId);
        return this;
    }

    public CreateParameters withDrawerSession(String drawerSessionId) {
        paramsMap.put("drawerSessionId", drawerSessionId);
        return this;
    }

    public CreateParameters withTenantId(String tenantId) {
        paramsMap.put("tenantId", tenantId);
        return this;
    }

    public CreateParameters withFromDate(String fromDate) {
        paramsMap.put("fromDate", fromDate + "-01-01");
        return this;
    }

    public CreateParameters withToDate(String toDate) {
        paramsMap.put("fromDate", toDate + "-12-31");
        return this;
    }

    public CreateParameters withValueType(String valueType) {
        paramsMap.put("valueType", valueType);
        return this;
    }

    public CreateParameters withUnderById(String underById) {
        paramsMap.put("underById", underById);
        return this;
    }

    public CreateParameters withCompanyId(String companyId) {
        paramsMap.put("companyId", companyId);
        return this;
    }

    public CreateParameters withCompanyType(String companyType) {
        paramsMap.put("companyType", companyType);
        return this;
    }

    public CreateParameters withCustomerCode(String customerCode) {
        paramsMap.put("customerCode", customerCode);
        return this;
    }

    public CreateParameters withCustomerId(String customerId) {
        paramsMap.put("customerId", customerId);
        return this;
    }

    public CreateParameters withManageCatalogue() {
        paramsMap.put("manageCatalogue", "company_managed");
        return this;
    }

    public CreateParameters withMerchantId(String merchantId) {
        paramsMap.put("merchantId", merchantId);
        return this;
    }

    public CreateParameters withStartDate(String startDate) {
        paramsMap.put("startDate", startDate);
        return this;
    }

    public CreateParameters withEndDate(String endDate) {
        paramsMap.put("endDate", endDate);
        return this;
    }

    public CreateParameters withRegisterId(String registerId) {
        paramsMap.put("registerId", registerId);
        return this;
    }

    public CreateParameters withChannel(String channel) {
        paramsMap.put("channel", channel);
        return this;
    }

    public CreateParameters withType(String type) {
        paramsMap.put("type", type);
        return this;
    }

    public CreateParameters withType(String[] type) {
        paramsMap.put("type", type);
        return this;
    }

    public CreateParameters withSettlementDate(String settlementDate) {
        paramsMap.put("settlementDate", settlementDate);
        return this;
    }

    public CreateParameters withTerminalName(String terminalName) {
        paramsMap.put("terminalName", terminalName);
        return this;
    }

    public CreateParameters withTerminalId(String terminalId) {
        paramsMap.put("terminalId", terminalId);
        return this;
    }

    public CreateParameters withCategory(String categoryName) {
        paramsMap.put("category", categoryName);
        return this;
    }

    public CreateParameters withCategoryArr(String categoryName) {
        paramsMap.put("category[]", categoryName);
        return this;
    }

    public CreateParameters withCatalogue(String catalogueName) {
        paramsMap.put("catalogue", catalogueName);
        return this;
    }

    public CreateParameters withLevel(String level) {
        paramsMap.put("level", level);
        return this;
    }

    public CreateParameters withValues(String[] values) {
        paramsMap.put("values", values);
        return this;
    }

    public CreateParameters withValuesArray(String values) {
        paramsMap.put("values[]", values);
        return this;
    }

    public CreateParameters withStatus(String status) {
        paramsMap.put("status", status);
        return this;
    }

    public CreateParameters withTypes(String type) {
        paramsMap.put("types", type);
        return this;
    }

    public CreateParameters withTransactionIds(String transactionIds) {
        paramsMap.put("transactionIds", transactionIds);
        return this;
    }

    public CreateParameters withFilterBy(String filterBy) {
        paramsMap.put("filterBy", filterBy);
        return this;
    }

    public CreateParameters withValues(String values) {
        paramsMap.put("values", values);
        return this;
    }

    public CreateParameters withFeature(String feature) {
        paramsMap.put("feature", feature);
        return this;
    }

    public CreateParameters withSettlementsEnabled(boolean settlementsEnabled) {
        paramsMap.put("settlementsEnabled", settlementsEnabled);
        return this;
    }

    public CreateParameters withPaymentsEnabled(boolean paymentsEnabled) {
        paramsMap.put("paymentsEnabled", paymentsEnabled);
        return this;
    }

    public CreateParameters withPayoutEnabled(boolean payoutEnabled) {
        paramsMap.put("payoutEnabled", payoutEnabled);
        return this;
    }

    public CreateParameters withUserId(String userId) {
        paramsMap.put("userId", userId);
        return this;
    }

    public CreateParameters withFilterByTime(String filterByTime) {
        paramsMap.put("filterByTime", filterByTime);
        return this;
    }

    public CreateParameters withArrayValues(String values) {
        paramsMap.put("values[]", values);
        return this;
    }

    public CreateParameters withReferenceRequestId(String referenceRequestId) {
        paramsMap.put("referenceRequestId", referenceRequestId);
        return this;
    }

    public CreateParameters withIncludeBalances(boolean includeBalances) {
        paramsMap.put("includeBalances", includeBalances);
        return this;
    }

    public CreateParameters withIncludeBalanceInquiry(boolean includeBanlanceInquiry) {
        paramsMap.put("includeBanlanceInquiry", includeBanlanceInquiry);
        return this;
    }

    public CreateParameters withSearch(Object search) {
        paramsMap.put("search", search);
        return this;
    }

    public CreateParameters withClientId(String clientId) {
        paramsMap.put("clientId", clientId);
        return this;
    }

    public CreateParameters withSubTypes(String[] subTypes) {
        paramsMap.put("subTypes", subTypes);
        return this;
    }

    public CreateParameters withSubType(String subType) {
        paramsMap.put("subtype", subType);
        return this;
    }

    public CreateParameters withTimeFrom(String timeFrom) {
        paramsMap.put("timeFrom", timeFrom);
        return this;
    }

    public CreateParameters withTimeTo(String timeTo) {
        paramsMap.put("timeTo", timeTo);
        return this;
    }

    public CreateParameters withEndedOnFrom(String timeTo) {
        paramsMap.put("endedOnFrom", timeTo);
        return this;
    }

    public CreateParameters withEndedOnTo(String timeTo) {
        paramsMap.put("endedOnTo", timeTo);
        return this;
    }

    public CreateParameters withCardType(String cardType) {
        paramsMap.put("cardType", cardType);
        return this;
    }

    public CreateParameters withGroup(String group) {
        paramsMap.put("group", group);
        return this;
    }

    public CreateParameters withFamily(String family) {
        paramsMap.put("family", family);
        return this;
    }

    public CreateParameters withBrand(String brand) {
        paramsMap.put("brand", brand);
        return this;
    }

    public CreateParameters withOwnerId(String ownerId) {
        paramsMap.put("ownerId", ownerId);
        return this;
    }

    public CreateParameters withOwnerType(String ownerType) {
        paramsMap.put("ownerType", ownerType);
        return this;
    }

    public CreateParameters withIsDeleted(boolean isDeleted) {
        paramsMap.put("isDeleted", isDeleted);
        return this;
    }

    public CreateParameters withStationMerchantId(String merchantId) {
        paramsMap.put("stationMerchantId", merchantId);
        return this;
    }

    public CreateParameters withSource(String source) {
        paramsMap.put("source", source);
        return this;
    }

    public CreateParameters withMerchantTypes(String merchantTypes) {
        paramsMap.put("merchantTypes", merchantTypes);
        return this;
    }

    public CreateParameters withMerchantType(String merchantTypes) {
        paramsMap.put("merchantTypes", merchantTypes);
        return this;
    }

    public CreateParameters withMerchantTypeArray(String merchantTypes) {
        paramsMap.put("merchantTypes[]", merchantTypes);
        return this;
    }

    public CreateParameters withBelongTo(String belongTo) {
        paramsMap.put("belongTo", belongTo);
        return this;
    }

    public CreateParameters withFrom(String from) {
        paramsMap.put("from", from);
        return this;
    }

    public CreateParameters withTo(String to) {
        paramsMap.put("to", to);
        return this;
    }

    public CreateParameters withReferenceId(String referenceId) {
        paramsMap.put("referenceId", referenceId);
        return this;
    }

    public CreateParameters withTargetId(String targetId) {
        paramsMap.put("targetId", targetId);
        return this;
    }

    public CreateParameters withSort(String sort) {
        paramsMap.put("sort", sort);
        return this;
    }

    public CreateParameters withDestroyId(String destroyId) {
        paramsMap.put("destroyId", destroyId);
        return this;
    }

    public CreateParameters withPhone(String phone) {
        paramsMap.put("phone", phone);
        return this;
    }

    public CreateParameters withName(String name) {
        paramsMap.put("name", name);
        return this;
    }

    public CreateParameters withRoyaltyPlanId(String royaltyPlanId) {
        paramsMap.put("royaltyPlanId", royaltyPlanId);
        return this;
    }

    public CreateParameters withSearchRebatePlan(String searchRebatePlan) {
        paramsMap.put("searchRebatePlan", searchRebatePlan);
        return this;
    }

    public CreateParameters withSearchSPAccountsCompanies(String searchSPAccountsCompanies) {
        paramsMap.put("searchSPAccountsCompanies", searchSPAccountsCompanies);
        return this;
    }

    public CreateParameters withPlanId(String planId) {
        paramsMap.put("planId", planId);
        return this;
    }

    public CreateParameters withSpId(String spId) {
        paramsMap.put("spId", spId);
        return this;
    }

    public CreateParameters withIdempotentId(String shiftId) {
        paramsMap.put("idempotentId", shiftId);
        return this;
    }

    public CreateParameters withCardNumber(String cardNumber) {
        paramsMap.put("cardNumber", cardNumber);
        return this;
    }

    public CreateParameters withCardNumberFrom(String cardNumberFrom) {
        paramsMap.put("cardNumberFrom", cardNumberFrom);
        return this;
    }

    public CreateParameters withCardNumberTo(String cardNumberTo) {
        paramsMap.put("cardNumberTo", cardNumberTo);
        return this;
    }

    public CreateParameters withPricingModel(String pricingModel) {
        paramsMap.put("pricingModel", pricingModel);
        return this;
    }

    public CreateParameters withIsPlainData(boolean isPlainData) {
        paramsMap.put("isPlainData", isPlainData);
        return this;
    }

    public CreateParameters withPaymentMethod(String paymentMethod) {
        paramsMap.put("paymentMethod", paymentMethod);
        return this;
    }

    public CreateParameters withMultipleMerchantId(String merchantId1, String merchantId2) {
        paramsMap.put("merchantId", new Tuple2(merchantId1, merchantId2));
        return this;
    }

    public CreateParameters withHouseAccountId(String houseAccountId) {
        paramsMap.put("houseAccountId", houseAccountId);
        return this;
    }

    public CreateParameters withCustomerName(String customerName) {
        paramsMap.put("customerName", customerName);
        return this;
    }

    public CreateParameters withBillingPlanId(String billingPlanId) {
        paramsMap.put("billingPlanId", billingPlanId);
        return this;
    }

    public CreateParameters withId(String id) {
        paramsMap.put("id", id);
        return this;
    }

    public CreateParameters withReloadName(String reloadName) {
        paramsMap.put("reloadName", reloadName);
        return this;
    }

    public CreateParameters withCardHolderName(String cardHolderName) {
        paramsMap.put("cardHolderName", cardHolderName);
        return this;
    }

    public CreateParameters withPurchaseType(String purchaseType) {
        paramsMap.put("purchaseType", purchaseType);
        return this;
    }

    public CreateParameters withMonetaryAmount(double monetaryAmount) {
        paramsMap.put("monetaryAmount", monetaryAmount);
        return this;
    }

    public CreateParameters withVolumeQuantity(double volumeQuantity) {
        paramsMap.put("volumeQuantity", volumeQuantity);
        return this;
    }

    public CreateParameters withTypeOfFuel(String typeOfFuel) {
        paramsMap.put("typeOfFuel", typeOfFuel);
        return this;
    }

    public CreateParameters withWalletBalance(double walletBalance) {
        paramsMap.put("walletBalance", walletBalance);
        return this;
    }

    public CreateParameters withEventType(String eventType) {
        paramsMap.put("eventType", eventType);
        return this;
    }

    public CreateParameters withOilco(String oilco) {
        paramsMap.put("oilco", oilco);
        return this;
    }

    public CreateParameters withCardSubtype(String cardSubtype) {
        paramsMap.put("cardSubtype", cardSubtype);
        return this;
    }

    public CreateParameters withExcludeClosed(boolean excludeClosed) {
        paramsMap.put("excludeClosed", excludeClosed);
        return this;
    }

    public CreateParameters withTransactionDateFrom(String transactionDateFrom) {
        paramsMap.put("transactionDateFrom", transactionDateFrom);
        return this;
    }

    public CreateParameters withTransactionDateTo(String transactionDateTo) {
        paramsMap.put("transactionDateTo", transactionDateTo);
        return this;
    }

    public CreateParameters withDateFrom(String dateFrom) {
        paramsMap.put("dateFrom", dateFrom);
        return this;
    }

    public CreateParameters withDateTo(String dateTo) {
        paramsMap.put("dateTo", dateTo);
        return this;
    }

    public CreateParameters withEligibleTypeOfFuel(String eligibleTypeOfFuel) {
        paramsMap.put("eligibleTypeOfFuel", eligibleTypeOfFuel);
        return this;
    }

    public CreateParameters withFormFactor(String formFactor) {
        paramsMap.put("formFactor", formFactor);
        return this;
    }

    public CreateParameters withEnabled(boolean enabled) {
        paramsMap.put("enabled", enabled);
        return this;
    }

    public CreateParameters withItems(String items) {
        paramsMap.put("items", items);
        return this;
    }

    public CreateParameters withReportType(String reportType) {
        paramsMap.put("reportType", reportType);
        return this;
    }


    public CreateParameters withIsoTransactionType(String isoTransactionType) {
        paramsMap.put("isoTransactionType", isoTransactionType);
        return this;
    }

    public CreateParameters withVehicleNumber(String vehicleNumber) {
        paramsMap.put("vehicleNumber", vehicleNumber);
        return this;
    }

    public CreateParameters withExternalId(Object externalId) {
        paramsMap.put("externalId", externalId);
        return this;
    }

    public CreateParameters withName(Object name) {
        paramsMap.put("name", name);
        return this;
    }

    public CreateParameters withEnable(Object enable) {
        paramsMap.put("enable", enable);
        return this;
    }

    public CreateParameters withStatementAccountStatus(String status) {
        paramsMap.put("balanceStatus", status);
        return this;
    }

    public CreateParameters withSalesRegion(String salesRegion) {
        paramsMap.put("salesRegion", salesRegion);
        return this;
    }

    public CreateParameters withTransactionDesc(String txnDesc) {
        paramsMap.put("transactionDesc", txnDesc);
        return this;
    }

    public CreateParameters withRegisterMobileNumber(Object enable) {
        paramsMap.put("enable", enable);
        return this;
    }

    public CreateParameters withPartnerID(String partnerId ) {
        paramsMap.put("partnerId", partnerId );
        return this;
    }

    public CreateParameters withDateRangeStart(String dateRangeStart) {
        paramsMap.put("date_range_start", dateRangeStart);
        return this;
    }

    public CreateParameters withDateRangeEnd(String dateRangeEnd) {
        paramsMap.put("date_range_end", dateRangeEnd);
        return this;
    }

    public CreateParameters withFleetPlan(String fleetPlan) {
        paramsMap.put("fleetplan", fleetPlan);
        return this;
    }

    public CreateParameters withRegion(String region) {
        paramsMap.put("region", region);
        return this;
    }

    public CreateParameters withEnterpriseId(String enterpriseId) {
        paramsMap.put("enterpriseId", enterpriseId);
        return this;
    }

    public CreateParameters withExpiredDate(String expiryDate) {
        paramsMap.put("expiryDate", expiryDate);
        return this;
    }

    public CreateParameters withCardGroupId(String cardgroupId) {
        paramsMap.put("cardgroupId", cardgroupId);
        return this;
    }

    public CreateParameters withServiceTypeId(String serviceTypeId) {
        paramsMap.put("serviceTypeId", serviceTypeId);
        return this;
    }

    public CreateParameters withPaymentStatus(String paymentStatus) {
        paramsMap.put("paymentStatus", paymentStatus);
        return this;
    }

    public CreateParameters withStartTime(String startTime) {
        paramsMap.put("startTime", startTime);
        return this;
    }

    public CreateParameters withEndTime(String endTime) {
        paramsMap.put("endTime", endTime);
        return this;
    }

    public CreateParameters withQuery(String query) {
        paramsMap.put("query", query);
        return this;
    }

    public CreateParameters withIncludeUserJoinStatus(boolean enabled) {
        paramsMap.put("includeUserJoinStatus", enabled);
        return this;
    }
    public CreateParameters withIncludeExpiredDeal(boolean enabled) {
        paramsMap.put("includeExpiredDeal", enabled);
        return this;
    }

    public CreateParameters withEmail(Object email) {
        paramsMap.put("email", email);
        return this;
    }

    public CreateParameters withPhone(Object phone) {
        paramsMap.put("phone", phone);
        return this;
    }

    public CreateParameters withCardId(Object cardId) {
        paramsMap.put("cardId", cardId);
        return this;
    }

    public CreateParameters withPerPage(Object perPage) {
        paramsMap.put("perPage", perPage);
        return this;
    }

    public CreateParameters withMinIncomePerMonth(Object minIncomePerMonth) {
        paramsMap.put("minIncomePerMonth", minIncomePerMonth);
        return this;
    }

    public CreateParameters withBank(Object bank) {
        paramsMap.put("bank", bank);
        return this;
    }

    public CreateParameters withBankId(Object bankId) {
        paramsMap.put("bankId", bankId);
        return this;
    }

    public CreateParameters withOrderType(Object orderType) {
        paramsMap.put("orderType", orderType);
        return this;
    }

    public CreateParameters withIdentificationNumber(Object identificationNumber) {
        paramsMap.put("identificationNumber", identificationNumber);
        return this;
    }

    public CreateParameters withState(Object state) {
        paramsMap.put("state", state);
        return this;
    }

    public CreateParameters withEmployType(Object employType) {
        paramsMap.put("employType", employType);
        return this;
    }

    public CreateParameters withHasCreditHistory(Object hasCreditHistory) {
        paramsMap.put("hasCreditHistory", hasCreditHistory);
        return this;
    }

    public CreateParameters withHasBalanceTransfer(Object hasBalanceTransfer) {
        paramsMap.put("hasBalanceTransfer", hasBalanceTransfer);
        return this;
    }

    public CreateParameters withIncomePerMonth(Object incomePerMonth) {
        paramsMap.put("incomePerMonth", incomePerMonth);
        return this;
    }

    public CreateParameters withCashback(Object cashback) {
        paramsMap.put("cashback", cashback);
        return this;
    }

    public CreateParameters withInterestRate(Object interestRate) {
        paramsMap.put("interestRate", interestRate);
        return this;
    }
    public CreateParameters withNumberOfWinners(Object amount) {
        paramsMap.put("numberOfWinners", amount);
        return this;
    }

    public CreateParameters withStatuses(Object statuses) {
        paramsMap.put("statuses", statuses);
        return this;
    }

    public CreateParameters withLimit(String limit) {
        paramsMap.put("limit", limit);
        return this;
    }

    public CreateParameters withTimezone(String timezone) {
        paramsMap.put("timezone", timezone);
        return this;
    }
    public CreateParameters withPoolView(Object poolView) {
        paramsMap.put("poolView", poolView);
        return this;
    }
    public CreateParameters withAddress(Object address) {
        paramsMap.put("address", address);
        return this;
    }
}
