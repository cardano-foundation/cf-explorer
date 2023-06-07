package constants;

public class Endpoints {
    public static class DelegationApi {

        public static final String POOL_DETAIL_URI = "delegations/pool-detail-header/{poolView}";
        public static final String POOL_DETAIL_DELEGATORS_URI = "delegations/pool-detail-delegators";
        public static final String POOL_DETAIL_ANALYTICS_URI = "delegations/pool-detail-analytics";
        public static final String POOL_HEADER_URI = "delegations/header";
        public static final String POOL_LIST_URI = "delegations/pool-list";

    }
    public static class AddressesApi {

        public static final String ADDRESS_URI = "addresses/{address}";
        public static final String TOP_ADDRESS_URI = "addresses/top-addresses";
        public static final String MIN_MAX_BALANCE_URI = "addresses/{address}";
        public static final String ADDRESS_ANALYTICS_URI = "addresses/analytics/{address}/{type}";
        public static final String ADDRESS_TRANSACTION_URI = "addresses/{address}/txs";

    }
    public static class BlockApi {

        public static final String BLOCK_URI = "blocks";
        public static final String BLOCK_DETAIL_URI = "blocks/{blockId}";
        public static final String BLOCK_LIST_URI = "blocks/{blockId}/txs";

    }

    public static class PoolControllerApi {
        public static final String REGISTRATION_POOLS = "pools/registration";
        public static final String DEREGISTRATION_POOLS = "pools/de-registration";
    }
    public static class TokenApi {
        public static final String TOKEN_ID = "tokenId";
        public static final String GET_LIST_TOKEN = "tokens";
        public static final String GET_A_TOKEN = "tokens/{"+ TOKEN_ID +"}";
        public static final String GET_TXS = "tokens/{"+ TOKEN_ID +"}/txs";
        public static final String GET_MINTS = "tokens/{"+ TOKEN_ID +"}/mints";
        public static final String GET_TOP_HOLDERS = "tokens/{"+ TOKEN_ID +"}/top_holders";
    }
    public static class TransactionApi {
        public static final String HASH_ID = "hash";
        public static final String TYPE = "type";
        public static final String TRANSACTION_HASH = "txs/{" + HASH_ID + "}";
        public static final String FILTER_TRANSACTION = "txs";
        public static final String TRANSACTION_GRAPH = "txs/graph/{" + TYPE + "}";
        public static final String TRANSACTION_CURRENT = "txs/current";
    }

    public static class ContractApi {
        public static final String GET_LIST_CONTRACT = "contracts";

    }

    public static class EpochApi{
        public static final String GET_EPOCH ="epochs";
        public static final String GET_CURRENT_EPOCH ="epochs/current";
        public static final String EPOCH_NO = "epochNo";
        public static final String GET_LIST_EPOCH_BY_EPOCH_NO ="epochs/{"+ EPOCH_NO +"}/blocks";
        public static final String GET_EPOCH_BY_EPOCH_NO ="epochs/{"+ EPOCH_NO +"}";

    }
    public static class PoliciesApi{
        public static final String POLICY_ID = "policyId";
        public static final String GET_TOKEN_BY_POLICIES = "policies/{"+POLICY_ID+"}/tokens";
        public static final String GET_POLICY_DETAIL = "policies/{"+POLICY_ID+"}";
        public static final String GET_HOLDER_BY_POLICIES = "policies/{"+POLICY_ID+"}/holders";
    }

    public static class StakeKeyApi{
        public static final String GET_STAKE_ADDRESS = "stakes/address/{address}";
        public static final String STAKE_KEY = "stakeKey";
        public static final String GET_STAKE_INSTANTANEOUS_REWARDS = "stakes/{"+ STAKE_KEY +"}/instantaneous-rewards";
        public static final String GET_STAKE = "stakes/{"+ STAKE_KEY +"}";
        public static final String GET_TOP_DELEGATORS = "stakes/top-delegators";
        public static final String GET_STAKE_REGISTRATION = "stakes/registration";
        public static final String GET_STAKE_DE_REGISTRATION = "stakes/de-registration";
        public static final String GET_STAKE_ANALYTICS = "stakes/analytics";
        public static final String GET_STAKE_HISTORY = "stakes/{"+ STAKE_KEY +"}/stake-history";
        public static final String GET_STAKE_WITHDRAWAL_HISTORY = "stakes/{"+ STAKE_KEY +"}/withdrawal-history";
        public static final String GET_STAKE_DELEGATION_HISTORY = "stakes/{"+ STAKE_KEY +"}/delegation-history";
        public static final String GET_STAKE_LIST_ADDRESS = "stakes/{"+ STAKE_KEY +"}/list-address";
    }
}
