package com.splitwise.mapper;

import com.splitwise.dto.request.RegisterRequestDTO;
import com.splitwise.dto.request.expense.ExpenseRequestDTO;
import com.splitwise.dto.response.ExpenseResponseDTO;
import com.splitwise.dto.response.GroupExpenseResponseDTO;
import com.splitwise.dto.response.SplitResponseDTO;
import com.splitwise.dto.response.UserResponseDTO;
import com.splitwise.dto.response.WalletResponseDTO;
import com.splitwise.entity.Expense;
import com.splitwise.entity.Group;
import com.splitwise.entity.Split;
import com.splitwise.entity.Users;
import com.splitwise.entity.Wallet;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-02T14:30:21+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.6 (Oracle Corporation)"
)
@Component
public class CustomMapperImpl implements CustomMapper {

    @Override
    public UserResponseDTO map(Users users) {
        if ( users == null ) {
            return null;
        }

        UserResponseDTO.UserResponseDTOBuilder userResponseDTO = UserResponseDTO.builder();

        userResponseDTO.id( users.getId() );
        userResponseDTO.name( users.getName() );
        userResponseDTO.email( users.getEmail() );

        return userResponseDTO.build();
    }

    @Override
    public Users map(UserResponseDTO userResponseDTO) {
        if ( userResponseDTO == null ) {
            return null;
        }

        Users.UsersBuilder users = Users.builder();

        users.id( userResponseDTO.getId() );
        users.name( userResponseDTO.getName() );
        users.email( userResponseDTO.getEmail() );

        return users.build();
    }

    @Override
    public List<ExpenseResponseDTO> map(List<Expense> expenses) {
        if ( expenses == null ) {
            return null;
        }

        List<ExpenseResponseDTO> list = new ArrayList<ExpenseResponseDTO>( expenses.size() );
        for ( Expense expense : expenses ) {
            list.add( map( expense ) );
        }

        return list;
    }

    @Override
    public List<UserResponseDTO> mapToUserDto(List<Users> users) {
        if ( users == null ) {
            return null;
        }

        List<UserResponseDTO> list = new ArrayList<UserResponseDTO>( users.size() );
        for ( Users users1 : users ) {
            list.add( map( users1 ) );
        }

        return list;
    }

    @Override
    public Expense map(ExpenseResponseDTO expenseResponseDTO) {
        if ( expenseResponseDTO == null ) {
            return null;
        }

        Expense.ExpenseBuilder expense = Expense.builder();

        expense.expenseType( expenseResponseDTO.getExpenseType() );
        expense.category( expenseResponseDTO.getCategory() );
        expense.description( expenseResponseDTO.getDescription() );
        expense.amount( expenseResponseDTO.getAmount() );
        expense.createdAt( expenseResponseDTO.getCreatedAt() );
        expense.payer( map( expenseResponseDTO.getPayer() ) );
        expense.groups( groupExpenseResponseDTOListToGroupList( expenseResponseDTO.getGroups() ) );
        expense.splits( splitResponseDTOListToSplitList( expenseResponseDTO.getSplits() ) );

        return expense.build();
    }

    @Override
    public ExpenseResponseDTO map(Expense expense) {
        if ( expense == null ) {
            return null;
        }

        ExpenseResponseDTO.ExpenseResponseDTOBuilder expenseResponseDTO = ExpenseResponseDTO.builder();

        expenseResponseDTO.expenseType( expense.getExpenseType() );
        expenseResponseDTO.category( expense.getCategory() );
        expenseResponseDTO.description( expense.getDescription() );
        expenseResponseDTO.amount( expense.getAmount() );
        expenseResponseDTO.createdAt( expense.getCreatedAt() );
        expenseResponseDTO.payer( map( expense.getPayer() ) );
        expenseResponseDTO.splits( splitListToSplitResponseDTOList( expense.getSplits() ) );
        expenseResponseDTO.groups( groupListToGroupExpenseResponseDTOList( expense.getGroups() ) );

        return expenseResponseDTO.build();
    }

    @Override
    public Expense map(ExpenseRequestDTO expenseRequestDTO) {
        if ( expenseRequestDTO == null ) {
            return null;
        }

        Expense.ExpenseBuilder expense = Expense.builder();

        expense.description( expenseRequestDTO.getDesc() );
        expense.expenseType( expenseRequestDTO.getExpenseType() );
        expense.category( expenseRequestDTO.getCategory() );
        expense.amount( expenseRequestDTO.getAmount() );

        return expense.build();
    }

    @Override
    public SplitResponseDTO map(Split split) {
        if ( split == null ) {
            return null;
        }

        SplitResponseDTO.SplitResponseDTOBuilder splitResponseDTO = SplitResponseDTO.builder();

        splitResponseDTO.user( map( split.getUser() ) );
        splitResponseDTO.amount( split.getAmount() );

        return splitResponseDTO.build();
    }

    @Override
    public SplitResponseDTO map(SplitResponseDTO splitResponseDTO) {
        if ( splitResponseDTO == null ) {
            return null;
        }

        SplitResponseDTO.SplitResponseDTOBuilder splitResponseDTO1 = SplitResponseDTO.builder();

        splitResponseDTO1.user( splitResponseDTO.getUser() );
        splitResponseDTO1.amount( splitResponseDTO.getAmount() );

        return splitResponseDTO1.build();
    }

    @Override
    public Group map(GroupExpenseResponseDTO groupExpenseResponseDTO) {
        if ( groupExpenseResponseDTO == null ) {
            return null;
        }

        Group.GroupBuilder group = Group.builder();

        group.name( groupExpenseResponseDTO.getName() );

        return group.build();
    }

    @Override
    public GroupExpenseResponseDTO map(Group group) {
        if ( group == null ) {
            return null;
        }

        GroupExpenseResponseDTO.GroupExpenseResponseDTOBuilder groupExpenseResponseDTO = GroupExpenseResponseDTO.builder();

        groupExpenseResponseDTO.name( group.getName() );

        return groupExpenseResponseDTO.build();
    }

    @Override
    public WalletResponseDTO map(Wallet wallet) {
        if ( wallet == null ) {
            return null;
        }

        WalletResponseDTO.WalletResponseDTOBuilder walletResponseDTO = WalletResponseDTO.builder();

        walletResponseDTO.user( map( wallet.getUser() ) );
        walletResponseDTO.payable( wallet.getPayable() );
        walletResponseDTO.own( wallet.getOwn() );
        walletResponseDTO.amount( wallet.getAmount() );

        return walletResponseDTO.build();
    }

    @Override
    public Users map(RegisterRequestDTO registerRequestDTO) {
        if ( registerRequestDTO == null ) {
            return null;
        }

        Users.UsersBuilder users = Users.builder();

        users.name( registerRequestDTO.getName() );
        users.email( registerRequestDTO.getEmail() );
        users.mobile( registerRequestDTO.getMobile() );
        users.password( registerRequestDTO.getPassword() );

        return users.build();
    }

    protected List<Group> groupExpenseResponseDTOListToGroupList(List<GroupExpenseResponseDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Group> list1 = new ArrayList<Group>( list.size() );
        for ( GroupExpenseResponseDTO groupExpenseResponseDTO : list ) {
            list1.add( map( groupExpenseResponseDTO ) );
        }

        return list1;
    }

    protected Split splitResponseDTOToSplit(SplitResponseDTO splitResponseDTO) {
        if ( splitResponseDTO == null ) {
            return null;
        }

        Split.SplitBuilder split = Split.builder();

        split.user( map( splitResponseDTO.getUser() ) );
        split.amount( splitResponseDTO.getAmount() );

        return split.build();
    }

    protected List<Split> splitResponseDTOListToSplitList(List<SplitResponseDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Split> list1 = new ArrayList<Split>( list.size() );
        for ( SplitResponseDTO splitResponseDTO : list ) {
            list1.add( splitResponseDTOToSplit( splitResponseDTO ) );
        }

        return list1;
    }

    protected List<SplitResponseDTO> splitListToSplitResponseDTOList(List<Split> list) {
        if ( list == null ) {
            return null;
        }

        List<SplitResponseDTO> list1 = new ArrayList<SplitResponseDTO>( list.size() );
        for ( Split split : list ) {
            list1.add( map( split ) );
        }

        return list1;
    }

    protected List<GroupExpenseResponseDTO> groupListToGroupExpenseResponseDTOList(List<Group> list) {
        if ( list == null ) {
            return null;
        }

        List<GroupExpenseResponseDTO> list1 = new ArrayList<GroupExpenseResponseDTO>( list.size() );
        for ( Group group : list ) {
            list1.add( map( group ) );
        }

        return list1;
    }
}
